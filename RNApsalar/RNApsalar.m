//
//  RNApsalar.m
//  RNApsalar
//
//  Created by sailplaneTW on 2017/1/9.
//  Copyright © 2017年 sailplaneTW. All rights reserved.
//

#import "RNApsalar.h"
#import "Apsalar.h"

@implementation RNApsalar

RCT_EXPORT_MODULE(RNApsalar);

RCT_EXPORT_METHOD(sendEvent:(NSString*)eventName attributes:(NSDictionary*)eventData)
{
    [Apsalar event:eventName withArgs:eventData];
}

@end
