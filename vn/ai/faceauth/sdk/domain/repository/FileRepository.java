package vn.ai.faceauth.sdk.domain.repository;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.File;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lvn/ai/faceauth/sdk/domain/repository/FileRepository;", "", "deleteStorageFiles", "", "getPathOfAllPhotos", "", "", "getPhotoFile", "Ljava/io/File;", "authenSDK_release"}, k = 1, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes4.dex */
public interface FileRepository {
    boolean deleteStorageFiles();

    List<String> getPathOfAllPhotos();

    File getPhotoFile();
}
