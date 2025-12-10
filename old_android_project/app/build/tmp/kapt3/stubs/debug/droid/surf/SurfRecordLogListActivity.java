package droid.surf;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J.\u0010\u0015\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001e"}, d2 = {"Ldroid/surf/SurfRecordLogListActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/widget/AdapterView$OnItemClickListener;", "()V", "binding", "Ldroid/surf/databinding/SubBinding;", "resultList", "", "Ldroid/surf/SurfRecordEntity;", "surfRecordViewModel", "Ldroid/surf/SurfRecordViewModel;", "getSurfRecordViewModel", "()Ldroid/surf/SurfRecordViewModel;", "surfRecordViewModel$delegate", "Lkotlin/Lazy;", "makeRecordLogListView", "", "records", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "arg0", "Landroid/widget/AdapterView;", "arg1", "Landroid/view/View;", "arg2", "", "arg3", "", "app_debug"})
public final class SurfRecordLogListActivity extends androidx.appcompat.app.AppCompatActivity implements android.widget.AdapterView.OnItemClickListener {
    @org.jetbrains.annotations.Nullable()
    private java.util.List<droid.surf.SurfRecordEntity> resultList;
    private droid.surf.databinding.SubBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy surfRecordViewModel$delegate = null;
    
    public SurfRecordLogListActivity() {
        super();
    }
    
    private final droid.surf.SurfRecordViewModel getSurfRecordViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void makeRecordLogListView(java.util.List<droid.surf.SurfRecordEntity> records) {
    }
    
    @java.lang.Override()
    public void onItemClick(@org.jetbrains.annotations.Nullable()
    android.widget.AdapterView<?> arg0, @org.jetbrains.annotations.NotNull()
    android.view.View arg1, int arg2, long arg3) {
    }
}