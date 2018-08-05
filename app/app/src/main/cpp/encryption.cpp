#include "argon2api.h"
#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_riguz_okapia_encrypt_Argon2_argon2iInternal(JNIEnv *env, jobject instance, jint iterations,
                                                     jint memory, jint parallelism,
                                                     jstring password_, jstring salt_,
                                                     jint hashLength) {
    const char *password = env->GetStringUTFChars(password_, 0);
    const char *salt = env->GetStringUTFChars(salt_, 0);

    Argon2 argon2(iterations, memory, parallelism, hashLength);
    uint8_t *hash = argon2.argon2i(password, salt);

    env->ReleaseStringUTFChars(password_, password);
    env->ReleaseStringUTFChars(salt_, salt);
    return 0;
}

extern "C"
JNIEXPORT jbyteArray JNICALL
Java_com_riguz_okapia_encrypt_Argon2_argon2dInternal(JNIEnv *env, jobject instance, jint iterations,
                                                     jint memory, jint parallelism,
                                                     jstring password_, jstring salt_,
                                                     jint hashLength) {
    const char *password = env->GetStringUTFChars(password_, 0);
    const char *salt = env->GetStringUTFChars(salt_, 0);

    // TODO

    env->ReleaseStringUTFChars(password_, password);
    env->ReleaseStringUTFChars(salt_, salt);

    return 0;
}
