package com.sap.driver;

import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.tech.Ndef;
import android.util.Log;

import java.io.IOException;

public class NFCReader {

    public static final String TAG = NFCReader.class.getSimpleName();

    public void onNfcDetected(Ndef ndef){

        readFromNFC(ndef);

    }

    private void readFromNFC(Ndef ndef) {

        try {
            ndef.connect();
            NdefMessage ndefMessage = ndef.getNdefMessage();
            String message = new String(ndefMessage.getRecords()[0].getPayload());
            Log.d(TAG, "readFromNFC: " + message);
            ndef.close();

        } catch (IOException | FormatException e) {
            e.printStackTrace();

        }
    }

}
