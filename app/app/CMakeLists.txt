# https://d.android.com/studio/projects/add-native-code.html

cmake_minimum_required(VERSION 3.4.1)

set(libs "${CMAKE_SOURCE_DIR}/libs")

add_library( argon2 SHARED IMPORTED )
set_target_properties(argon2 PROPERTIES IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libargon2.so")

add_library( native-lib
             SHARED
             src/main/cpp/native-lib.cpp )

add_library( encryption
             SHARED
             src/main/cpp/encryption.cpp )

find_library( log-lib log )

target_link_libraries(encryption
                      argon2  ${log-lib})

target_link_libraries(native-lib
                      ${log-lib} )