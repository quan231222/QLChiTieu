package com.example.demoqlchitieu.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.demoqlchitieu.dao.AppDatabase;
import com.example.demoqlchitieu.dao.LoaiThuDao;
import com.example.demoqlchitieu.entity.LoaiThu;

import java.util.List;

public class LoaiThuRepository {
    private LoaiThuDao mLoaiThuDao;
    private LiveData<List<LoaiThu>> mAllLoaiThu;

    public LoaiThuRepository(Application application) {
        this.mLoaiThuDao = AppDatabase.getDatabase(application).loaiThuDao();
        mAllLoaiThu = mLoaiThuDao.findAll();
    }

    public LiveData<List<LoaiThu>> getAllLoaiThu() {
        return mAllLoaiThu;
    }

    public void insert(LoaiThu loaiThu) {
        new InsertAsyncTask(mLoaiThuDao).execute(loaiThu);
    }

    class InsertAsyncTask extends AsyncTask<LoaiThu, Void, Void> {
        private LoaiThuDao mLoaiThuDao;
        public InsertAsyncTask(LoaiThuDao loaiThuDao) {
            this.mLoaiThuDao = loaiThuDao;
        }

        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            mLoaiThuDao.insert(loaiThus[0]);
            return null;
        }
    }
}
