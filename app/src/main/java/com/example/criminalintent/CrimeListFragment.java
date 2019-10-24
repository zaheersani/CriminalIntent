package com.example.criminalintent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CrimeListFragment extends Fragment {
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        // Creates CrimeLab Singleton object
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        // Access a list of Crimes from CrimeLab
        List<Crime> crimes = crimeLab.getCrimes();
        // Pass the list of Crimes to Adapter for ViewHolder
        mAdapter = new CrimeAdapter(crimes);
        // Set the Adapter for RecyclerView
        mCrimeRecyclerView.setAdapter(mAdapter);
    }

    private class CrimeHolder extends RecyclerView.ViewHolder {
        // Declare TextView to show Crime Data
        private TextView mTitleTextView;
        private TextView mDateTextView;

        // Declare a Crime Object
        private Crime mCrime;

        // Specify layout to be used for ViewHolder
        public CrimeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_crime, parent, false));

            // Initialize TextViews to display Crime Data
            mTitleTextView = (TextView) itemView.findViewById(R.id.crime_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.crime_date);
        }

        /**
         * Custom method which takes Crime object as an argument and set Crime Data on View
         * @param crime Crime object to bind with a single ViewHolder
         */
        public void bind(Crime crime) {
            mCrime = crime;
            mTitleTextView.setText(mCrime.getTitle());
            mDateTextView.setText(mCrime.getDate().toString());
        }
    }

    /**
     * Adapter class for CrimeHolder (ViewHolder) for binding Crime List
     */
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
        // Declare List of type Crime
        private List<Crime> mCrimes;

        /**
         * Constructor to initialize Adapter with Crime List
         * @param crimes
         */
        public CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CrimeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime crime = mCrimes.get(position);
            holder.bind(crime);
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }
}
