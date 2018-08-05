LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := libargon2
LOCAL_CPPFLAGS += -fexceptions 

LOCAL_C_INCLUDES := \
    $(LOCAL_PATH) \
    $(LOCAL_PATH)/include \

LOCAL_SRC_FILES := \
    src/argon2.c \
    src/core.c \
    src/blake2/blake2b.c \
    src/encoding.c \
    src/ref.c \
    src/thread.c \

include $(BUILD_SHARED_LIBRARY)
