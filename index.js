"use strict";

import { NativeModules } from 'react-native';

const RNApsalar = NativeModules.RNApsalar;

const ReactNativeApsalar = {
    sendEvent: function(eventName, eventDetail) {
        RNApsalar.sendEvent(eventName, eventDetail)
    },
}

module.exports = ReactNativeApsalar;
