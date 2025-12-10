package droid.surf;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\b\u0010\u0006\u001a\u00020\u0003H\'J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\'\u00a8\u0006\u000e"}, d2 = {"Ldroid/surf/SurfRecordDao;", "", "delete", "", "date", "", "deleteAll", "getAll", "Lkotlinx/coroutines/flow/Flow;", "", "Ldroid/surf/SurfRecordEntity;", "insert", "record", "update", "app_debug"})
@androidx.room.Dao()
public abstract interface SurfRecordDao {
    
    @androidx.room.Query(value = "SELECT * FROM surf_records ORDER BY ymd DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<droid.surf.SurfRecordEntity>> getAll();
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    droid.surf.SurfRecordEntity record);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    droid.surf.SurfRecordEntity record);
    
    @androidx.room.Query(value = "DELETE FROM surf_records WHERE date = :date")
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    java.lang.String date);
    
    @androidx.room.Query(value = "DELETE FROM surf_records")
    public abstract void deleteAll();
}