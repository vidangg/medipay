package com.google.common.graph;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Set;
import javax.annotation.CheckForNull;

@DoNotMock("Use NetworkBuilder to create a real instance")
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public interface Network<N, E> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<E> adjacentEdges(E edge);

    Set<N> adjacentNodes(N node);

    boolean allowsParallelEdges();

    boolean allowsSelfLoops();

    Graph<N> asGraph();

    int degree(N node);

    @CheckForNull
    E edgeConnectingOrNull(EndpointPair<N> endpoints);

    @CheckForNull
    E edgeConnectingOrNull(N nodeU, N nodeV);

    ElementOrder<E> edgeOrder();

    Set<E> edges();

    Set<E> edgesConnecting(EndpointPair<N> endpoints);

    Set<E> edgesConnecting(N nodeU, N nodeV);

    boolean equals(@CheckForNull Object object);

    boolean hasEdgeConnecting(EndpointPair<N> endpoints);

    boolean hasEdgeConnecting(N nodeU, N nodeV);

    int hashCode();

    int inDegree(N node);

    Set<E> inEdges(N node);

    Set<E> incidentEdges(N node);

    EndpointPair<N> incidentNodes(E edge);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N node);

    Set<E> outEdges(N node);

    Set<N> predecessors(N node);

    @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    Set<N> successors(N node);

    /* JADX WARN: Multi-variable type inference failed */
    /* bridge */ /* synthetic */ default Iterable predecessors(Object node) {
        return predecessors((Network<N, E>) node);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    /* bridge */ /* synthetic */ default Iterable successors(Object node) {
        return successors((Network<N, E>) node);
    }
}
