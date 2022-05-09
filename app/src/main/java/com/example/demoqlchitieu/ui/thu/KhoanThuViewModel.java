package com.example.demoqlchitieu.ui.thu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.demoqlchitieu.entity.LoaiThu;
import com.example.demoqlchitieu.entity.Thu;
import com.example.demoqlchitieu.repository.ThuRepository;

import java.util.List;

public class KhoanThuViewModel extends AndroidViewModel {
    private ThuRepository mThuRepository;
    private LoaiThuViewModel mLoaiThuViewModel;
    private LiveData<List<Thu>> mAllThu;
    private LiveData<List<LoaiThu>> mAllLoaiThu;

    public KhoanThuViewModel(@NonNull Application application) {
        super(application);
        mThuRepository = new ThuRepository(application);
        mAllThu = mThuRepository.getAllThu();
        mLoaiThuViewModel = new LoaiThuViewModel(application);
        mAllLoaiThu = mLoaiThuViewModel.getmAllLoaiThu();
    }

    public LiveData<List<Thu>> getAllThu() {
        return mAllThu;
    }
    public LiveData<List<LoaiThu>> getmAllLoaiThu() {
        return mAllLoaiThu;
    }
    public void insert(Thu thu) {
        mThuRepository.insert(thu);
    }
    public void delete(Thu thu) {
        mThuRepository.delete(thu);
    }
    public void update(Thu thu) {
        mThuRepository.update(thu);
    }
}