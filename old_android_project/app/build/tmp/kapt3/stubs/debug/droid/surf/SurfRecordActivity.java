package droid.surf;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010(\u001a\u00020)H\u0002J\u0006\u0010*\u001a\u00020)J\u0006\u0010+\u001a\u00020)J\b\u0010,\u001a\u00020)H\u0002J\b\u0010-\u001a\u00020)H\u0002J\b\u0010.\u001a\u00020)H\u0002J\b\u0010/\u001a\u00020)H\u0002J\u0018\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\bH\u0002J\u001a\u00103\u001a\u00020!2\b\u00104\u001a\u0004\u0018\u00010\b2\u0006\u00102\u001a\u00020\bH\u0002J\u0010\u00105\u001a\u00020)2\u0006\u00106\u001a\u000207H\u0016J\u0012\u00108\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010:H\u0014J\u0010\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020=H\u0016J(\u0010>\u001a\u00020)2\u0006\u00106\u001a\u00020?2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\f2\u0006\u0010B\u001a\u00020\fH\u0016J\u0010\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020EH\u0016J \u0010F\u001a\u00020)2\u0006\u00106\u001a\u00020G2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\fH\u0016J\b\u0010H\u001a\u00020)H\u0002J\b\u0010I\u001a\u00020)H\u0002J\b\u0010J\u001a\u00020)H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\'\u001a\u0004\b$\u0010%\u00a8\u0006K"}, d2 = {"Ldroid/surf/SurfRecordActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "Landroid/widget/DatePicker$OnDateChangedListener;", "Landroid/widget/TimePicker$OnTimeChangedListener;", "()V", "CROWD_VALUE_LIST", "", "", "CROWD_VALUE_MAP", "", "MENU_ITEM0", "", "MENU_ITEM2", "MENU_ITEM3", "MENU_ITEM4", "MENU_ITEM5", "MENU_ITEM6", "SIZE_VALUE_LIST", "SIZE_VALUE_MAP", "TYPE_VALUE_LIST", "TYPE_VALUE_MAP", "WEATHER_VALUE_LIST", "WEATHER_VALUE_MAP", "WIND_VALUE_LIST", "WIND_VALUE_MAP", "binding", "Ldroid/surf/databinding/MainBinding;", "currentIndex", "dataList", "", "Ldroid/surf/SurfRecordEntity;", "isReg", "", "surfRecordViewModel", "Ldroid/surf/SurfRecordViewModel;", "getSurfRecordViewModel", "()Ldroid/surf/SurfRecordViewModel;", "surfRecordViewModel$delegate", "Lkotlin/Lazy;", "delete", "", "deleteAll", "deleteSingle", "execBtnSave", "exportRecordLog", "init", "initStatus", "isInteger", "num", "data", "isNull", "str", "onClick", "arg0", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDateChanged", "Landroid/widget/DatePicker;", "arg1", "arg2", "arg3", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onTimeChanged", "Landroid/widget/TimePicker;", "refreshSpinner", "setData", "updateStatus", "app_debug"})
public final class SurfRecordActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener, android.widget.DatePicker.OnDateChangedListener, android.widget.TimePicker.OnTimeChangedListener {
    private final int MENU_ITEM0 = 0;
    private final int MENU_ITEM2 = 2;
    private final int MENU_ITEM3 = 3;
    private final int MENU_ITEM4 = 4;
    private final int MENU_ITEM5 = 5;
    private final int MENU_ITEM6 = 6;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> WEATHER_VALUE_LIST = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.String> WEATHER_VALUE_MAP = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> WIND_VALUE_LIST = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.String> WIND_VALUE_MAP = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> SIZE_VALUE_LIST = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.String> SIZE_VALUE_MAP = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> CROWD_VALUE_LIST = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.String> CROWD_VALUE_MAP = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> TYPE_VALUE_LIST = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.String> TYPE_VALUE_MAP = null;
    private boolean isReg = true;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<droid.surf.SurfRecordEntity> dataList;
    private int currentIndex = 0;
    private droid.surf.databinding.MainBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy surfRecordViewModel$delegate = null;
    
    public SurfRecordActivity() {
        super();
    }
    
    private final droid.surf.SurfRecordViewModel getSurfRecordViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void init() {
    }
    
    private final void refreshSpinner() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View arg0) {
    }
    
    private final void initStatus() {
    }
    
    private final void updateStatus() {
    }
    
    private final void setData() {
    }
    
    private final void execBtnSave() {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void exportRecordLog() {
    }
    
    private final void delete() {
    }
    
    private final boolean isInteger(java.lang.String num, java.lang.String data) {
        return false;
    }
    
    private final boolean isNull(java.lang.String str, java.lang.String data) {
        return false;
    }
    
    @java.lang.Override()
    public void onTimeChanged(@org.jetbrains.annotations.NotNull()
    android.widget.TimePicker arg0, int arg1, int arg2) {
    }
    
    @java.lang.Override()
    public void onDateChanged(@org.jetbrains.annotations.NotNull()
    android.widget.DatePicker arg0, int arg1, int arg2, int arg3) {
    }
    
    public final void deleteAll() {
    }
    
    public final void deleteSingle() {
    }
}