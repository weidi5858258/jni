//
// Created by ex-wangliwei on 2016/2/14.
//

#include "util.h"

/*JNIEXPORT jint JNICALL Java_com_mobilesoft_sms_mobilesoftinfo_SendSMS_SmsInit(JNIEnv *env, jclass jobject){
    return SmsInit();
}

JNIEXPORT jint JNICALL Java_com_mobilesoft_sms_mobilesoftinfo_SendSMS_SmsSend(JNIEnv *env,
                                                                              jclass jobject,
                                                                              jbyteArray mobileno,
                                                                              jbyteArray smscontent){
    char *pSmscontent;
//jsize theArrayLengthJ = (*env)->GetArrayLength(env,mobileno);
    jbyte *arrayBody = (*env)->GetByteArrayElements(env, mobileno, 0);
    char *pMobileNo = (char *) arrayBody;
    printf("[%s]\n ", pMobileNo);

//jsize size = (*env)->GetArrayLength(env,smscontent);
    arrayBody = (*env)->GetByteArrayElements(env, smscontent, 0);
    pSmscontent = (char *) arrayBody;
    printf("<%s>\n", pSmscontent);
    return SmsSend(pMobileNo, pSmscontent);
}

jdouble Java_pkg_Cls_f__ILjava_lang_String_2 (
        *//* 接口指针 *//*
        JNIEnv *env,
        *//* “this”指针 *//*
        jobject obj,
        *//* 第一个参数 *//*
        jint i,
        *//* 第二个参数 *//*
        jstring s)
{
    *//* 取得Java字符串的C版本 *//*
    const char *str = (*env)->GetStringUTFChars(env, s, 0);
    *//* 处理该字符串 *//*
    ...
    *//* 至此完成对 str 的处理 *//*
    (*env)->ReleaseStringUTFChars(env, s, str);
    return ...
}*/

