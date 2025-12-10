package droid.surf

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SurfRecordViewModel(private val repository: SurfRecordRepository) : ViewModel() {

    val allRecords: LiveData<List<SurfRecordEntity>> = repository.allRecords.asLiveData()

    fun insert(record: SurfRecordEntity) = viewModelScope.launch {
        repository.insert(record)
    }

    fun update(record: SurfRecordEntity) = viewModelScope.launch {
        repository.update(record)
    }

    fun delete(date: String) = viewModelScope.launch {
        repository.delete(date)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }
}

class SurfRecordViewModelFactory(private val repository: SurfRecordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SurfRecordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SurfRecordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
