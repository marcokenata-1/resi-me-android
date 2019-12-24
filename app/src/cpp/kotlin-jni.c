//
// Created by Marco Kenata on 2019-12-24.
//
#include <string.h>
#include <jni.h>
#include <stdio.h>

JNIEXPORT jstring JNICALL Java_id_ac_ui_cs_mobileprogramming_marcokenata_resi_1me_di_NetModule_httpUrl
  (JNIEnv* env, jobject obj,jstring jstring1) {
    return (*env)->NewStringUTF(env, "https://www.themealdb.com/api/json/v1/1/");

}
