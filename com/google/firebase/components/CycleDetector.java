package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class CycleDetector {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class Dep {
        private final Qualified<?> anInterface;
        private final boolean set;

        private Dep(Qualified<?> qualified, boolean z) {
            this.anInterface = qualified;
            this.set = z;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Dep)) {
                return false;
            }
            Dep dep = (Dep) obj;
            return dep.anInterface.equals(this.anInterface) && dep.set == this.set;
        }

        public int hashCode() {
            return ((this.anInterface.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.set).hashCode();
        }
    }

    CycleDetector() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class ComponentNode {
        private final Component<?> component;
        private final Set<ComponentNode> dependencies = new HashSet();
        private final Set<ComponentNode> dependents = new HashSet();

        ComponentNode(Component<?> component) {
            this.component = component;
        }

        void addDependency(ComponentNode componentNode) {
            this.dependencies.add(componentNode);
        }

        void addDependent(ComponentNode componentNode) {
            this.dependents.add(componentNode);
        }

        Set<ComponentNode> getDependencies() {
            return this.dependencies;
        }

        void removeDependent(ComponentNode componentNode) {
            this.dependents.remove(componentNode);
        }

        Component<?> getComponent() {
            return this.component;
        }

        boolean isRoot() {
            return this.dependents.isEmpty();
        }

        boolean isLeaf() {
            return this.dependencies.isEmpty();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void detect(List<Component<?>> list) {
        Set<ComponentNode> graph = toGraph(list);
        Set<ComponentNode> roots = getRoots(graph);
        int i = 0;
        while (!roots.isEmpty()) {
            ComponentNode next = roots.iterator().next();
            roots.remove(next);
            i++;
            for (ComponentNode componentNode : next.getDependencies()) {
                componentNode.removeDependent(next);
                if (componentNode.isRoot()) {
                    roots.add(componentNode);
                }
            }
        }
        if (i == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ComponentNode componentNode2 : graph) {
            if (!componentNode2.isRoot() && !componentNode2.isLeaf()) {
                arrayList.add(componentNode2.getComponent());
            }
        }
        throw new DependencyCycleException(arrayList);
    }

    private static Set<ComponentNode> toGraph(List<Component<?>> list) {
        Set<ComponentNode> set;
        HashMap hashMap = new HashMap(list.size());
        Iterator<Component<?>> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                Component<?> next = it.next();
                ComponentNode componentNode = new ComponentNode(next);
                for (Qualified<? super Object> qualified : next.getProvidedInterfaces()) {
                    Dep dep = new Dep(qualified, !next.isValue());
                    if (!hashMap.containsKey(dep)) {
                        hashMap.put(dep, new HashSet());
                    }
                    Set set2 = (Set) hashMap.get(dep);
                    if (!set2.isEmpty() && !dep.set) {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", qualified));
                    }
                    set2.add(componentNode);
                }
            } else {
                Iterator it2 = hashMap.values().iterator();
                while (it2.hasNext()) {
                    for (ComponentNode componentNode2 : (Set) it2.next()) {
                        for (Dependency dependency : componentNode2.getComponent().getDependencies()) {
                            if (dependency.isDirectInjection() && (set = (Set) hashMap.get(new Dep(dependency.getInterface(), dependency.isSet()))) != null) {
                                for (ComponentNode componentNode3 : set) {
                                    componentNode2.addDependency(componentNode3);
                                    componentNode3.addDependent(componentNode2);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = hashMap.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                return hashSet;
            }
        }
    }

    private static Set<ComponentNode> getRoots(Set<ComponentNode> set) {
        HashSet hashSet = new HashSet();
        for (ComponentNode componentNode : set) {
            if (componentNode.isRoot()) {
                hashSet.add(componentNode);
            }
        }
        return hashSet;
    }
}
