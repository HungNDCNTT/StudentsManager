package vn.poly.ass.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.poly.ass.R;
import vn.poly.ass.model.Class;
import vn.poly.ass.sqlite.Controller;

public class MainActivity extends AppCompatActivity {
    Controller controller =null;
    protected AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller =new Controller(MainActivity.this);
    }

    public void addClass(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View alert = LayoutInflater.from(this).inflate(R.layout.addclassdialog, null);
        builder.setView(alert);

        final Button btnSave, btnClear;
        final EditText edtID, edtName;

        btnClear = alert.findViewById(R.id.btnClear);
        btnSave = alert.findViewById(R.id.btnSave);
        edtID = alert.findViewById(R.id.edtID);
        edtName = alert.findViewById(R.id.edtName);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtID.setText("");
                edtName.setText("");
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!edtID.getText().toString().equals("") && !edtName.getText().toString().equals("")) {

                        long result = controller.insertData(new Class(edtID.getText().toString(), edtName.getText().toString()));
                        if (result>0){
                            Toast.makeText(MainActivity.this, "Lưu thành công", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        } else {
                            Toast.makeText(MainActivity.this, "Mã lớp này đã tồn tại", Toast.LENGTH_SHORT).show();
                        }


                    } else {
                        Toast.makeText(MainActivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Lỗi " + e, Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.create();
        dialog = builder.show();
    }
    public void showClass(View view) {
        Intent intent = new Intent(MainActivity.this, Main2.class);
        startActivity(intent);
    }

    public void studentTool(View view) {
        Intent intent = new Intent(MainActivity.this, Main3.class);
        startActivity(intent);
    }

    public void closeDialog(View view) {
        dialog.dismiss();
    }
}


