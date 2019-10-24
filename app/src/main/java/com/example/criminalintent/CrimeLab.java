package com.example.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Singleton CrimLab class which provides global access to the List of Crimes
 */
public class CrimeLab {

    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;

    /*
    * Context class:
    */

    /**
     * Static method which is Singleton
     * @param context Interface to global information about an application environment.
     *                This is an abstract class whose implementation is provided by the Android system.
     *                It allows access to application-specific resources and classes, as well as
     *                up-calls for application-level operations such as launching activities,
     *                broadcasting and receiving intents, etc.
     * @return Returns CrimeLab static object which implements Singleton behaviour
     */
    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            // Call constructor for once in application lifetime
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    /**
     * Initializes Crimes List
     * @param context
     */
    private CrimeLab(Context context) {
        // Initialize List for the first time only
        mCrimes = new ArrayList<>();
        // Hardcoding some crime objects
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0); // Every other one
            mCrimes.add(crime);
        }
    }

    /**
     * Returns list of Crimes containing Crime objects
     * @return List of type Crime
     */
    public List<Crime> getCrimes() {
        return mCrimes;
    }

    /**
     * Returns Crime object by searching from the List of Crimes based in UUID
     * @param id UUID
     * @return Crime object
     */
    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }

}
