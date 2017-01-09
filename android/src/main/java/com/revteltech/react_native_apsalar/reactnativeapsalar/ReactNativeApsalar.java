package com.revteltech.react_native_apsalar.reactnativeapsalar;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMapKeySetIterator;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.lang.Exception;
import org.json.JSONObject;

import com.apsalar.sdk.Apsalar;

import android.util.Log;

public class ReactNativeApsalar extends ReactContextBaseJavaModule {
    final static String ModuleName = "RNApsalar";

    public ReactNativeApsalar(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return ModuleName;
    }

    @ReactMethod
    public void sendEvent(final String eventName, final ReadableMap readableMap) {
        Apsalar.eventJSON(eventName, convertReadableMapToJson(readableMap));
    }

    @ReactMethod
    public void test() {
        Log.d(ModuleName, "ReactNativeApsala.test is called");
        return;
    }

    private JSONObject convertReadableMapToJson(final ReadableMap readableMap) {
		ReadableMapKeySetIterator iterator = readableMap.keySetIterator();
        JSONObject json = new JSONObject();

        try {
            while (iterator.hasNextKey()) {
                String key = iterator.nextKey();

                switch (readableMap.getType(key)) {
                    case Null:
                        json.put(key, null);
                        break;
                    case Boolean:
                        json.put(key, readableMap.getBoolean(key));
                        break;
                    case Number:
                        json.put(key, readableMap.getDouble(key));
                        break;
                    case String:
                        json.put(key, readableMap.getString(key));
                        break;
                    case Array:
                        json.put(key, readableMap.getArray(key));
                        break;
                    case Map:
                        json.put(key, convertReadableMapToJson(readableMap.getMap(key)));
                        break;
                    default:
                        break;
                }
            }
        } catch(Exception ex) {
            Log.d(ModuleName, "convertReadableMapToJson fail: "+ex);
        }

        return json;
    }
}
