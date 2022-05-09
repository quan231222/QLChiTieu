package com.example.demoqlchitieu.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.demoqlchitieu.R;
import com.example.demoqlchitieu.entity.LoaiThu;
import com.example.demoqlchitieu.ui.thu.LoaiThuFragment;
import com.example.demoqlchitieu.ui.thu.LoaiThuViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class LoaiThuDialog {
    private LoaiThuViewModel mViewModel;
    private LayoutInflater mLayoutInflater;
    private AlertDialog mDialog;

    private TextInputEditText etId, etName;
    private boolean mEditMode;

    public LoaiThuDialog(final Context context, LoaiThuFragment fragment, LoaiThu ... loaiThu) {
        mViewModel = fragment.getViewModel();
        mLayoutInflater = LayoutInflater.from(context);
        View view = mLayoutInflater.inflate(R.layout.dialog_loai_thu, null);
        etId = view.findViewById(R.id.etId);
        etName = view.findViewById(R.id.etName);
        if (loaiThu != null && loaiThu.length > 0) {
            etId.setText("" + loaiThu[0].lid);
            etName.setText(loaiThu[0].ten);
            mEditMode = true;
        } else {
            mEditMode = false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setView(view)
                .setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mDialog.dismiss();
                    }
                })
                .setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        LoaiThu lt = new LoaiThu();
                        lt.ten = etName.getText().toString();
                        if (mEditMode) {
                            lt.lid = Integer.parseInt(etId.getText().toString());
                            mViewModel.update(lt);
                        } else {
                            mViewModel.insert(lt);
                            Toast.makeText(context, "Loại thu được lưu", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        mDialog = builder.create();
    }

    public void show() {
        mDialog.show();
    }
}
