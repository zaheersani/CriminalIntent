package com.example.criminalintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();
}
