package com.example.uibasicspart3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener
{
    private CheckBox checkBoxHarry, checkboxMatrix, checkboxJoker;
    private RadioGroup rgMaritalStatus;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxHarry = findViewById(R.id.checkboxHarry);
        checkboxMatrix = findViewById(R.id.checkboxMatrix);
        checkboxJoker = findViewById(R.id.checkboxJoker);
        rgMaritalStatus = findViewById(R.id.rgMaritalStatus);
        progressBar = findViewById(R.id.progressBar);

        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 10; i++)
                {
                    progressBar.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }
            }
        });
        thread.start();

        int checkedButtonId = rgMaritalStatus.getCheckedRadioButtonId();

        switch (checkedButtonId)
        {
            case R.id.rbMarried:
                Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbSingle:
                Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbInRel:
                Toast.makeText(MainActivity.this, "In a Relationship", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        rgMaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                {
                    case R.id.rbMarried:
                        Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbSingle:
                        Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbInRel:
                        Toast.makeText(MainActivity.this, "In a Relationship", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

        if (checkBoxHarry.isChecked())
        {
            Toast.makeText(MainActivity.this, "You have watched Harry Potter! Me too!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(MainActivity.this, "You NEED to watch Harry Potter!", Toast.LENGTH_SHORT).show();
        }

        checkBoxHarry.setOnCheckedChangeListener(this);
        checkboxJoker.setOnCheckedChangeListener(this);
        checkboxMatrix.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        if (buttonView.getId() == R.id.checkboxHarry)
        {
            if (isChecked)
            {
                Toast.makeText(MainActivity.this, "You have watched Harry Potter! Me too!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(MainActivity.this, "You NEED to watch Harry Potter!", Toast.LENGTH_SHORT).show();
            }
        }
        else if (buttonView.getId() == R.id.checkboxJoker)
        {
            if (isChecked)
            {
                Toast.makeText(MainActivity.this, "You have watched Joker! Me too!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(MainActivity.this, "You NEED to watch Joker!", Toast.LENGTH_SHORT).show();
            }
        }
        else if (buttonView.getId() == R.id.checkboxMatrix)
        {
            if (isChecked)
            {
                Toast.makeText(MainActivity.this, "You have watched The Matrix! Me too!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(MainActivity.this, "You NEED to watch The Matrix!", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            ; /* Do nothing */
        }
    }
}