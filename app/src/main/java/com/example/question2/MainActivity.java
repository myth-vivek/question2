package com.example.question2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtInput;
    private TextView txtOutput;
    private Button btnConvert;
    private String[] ones = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
            "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private String[] tens = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInput = findViewById(R.id.num);
        txtOutput = findViewById(R.id.txtOutput);
        btnConvert = findViewById(R.id.btn_convert);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int input = Integer.parseInt(txtInput.getText().toString());
                if (input<20){
                    txtOutput.setText(ones[input]);
                }else if(input<100) {
                    int tensIndex = input / 10;
                    int onesIndex = input % 10;

                    if (onesIndex != 0) {
                        txtOutput.setText(tens[tensIndex] + " " + ones[onesIndex]);
                    } else {
                        txtOutput.setText(tens[tensIndex]);
                    }
                }
                else {
                    int hundredsIndex = input / 100;
                    int remainder = input % 100;
                    int tensIndex = remainder / 10;
                    int onesIndex = remainder % 10;

                    if (onesIndex != 0){
                        txtOutput.setText(ones[hundredsIndex]+" Hundred "+tens[tensIndex]+" "+ones[onesIndex]);
                    }else{
                        txtOutput.setText(ones[hundredsIndex]+" Hundred "+tens[tensIndex]);
                    }
                }
            }
        });
    }
}


