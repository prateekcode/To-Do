package com.androidmonk.to_do;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.androidmonk.to_do.database.AppDatabase;
import com.androidmonk.to_do.database.TaskEntry;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    public static final String TAG = MainViewModel.class.getSimpleName();
    private LiveData<List<TaskEntry>> tasks;

    public MainViewModel(@NonNull Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the tasks from the Database");
        tasks = database.taskDao().loadAllTasks();
    }

    public LiveData<List<TaskEntry>> getTasks(){
        return tasks;
    }
}
