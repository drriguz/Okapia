# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

cmake_minimum_required(VERSION 3.4.1)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
add_library( argon2 SHARED IMPORTED )

set(libs "${CMAKE_SOURCE_DIR}/libs")
set_target_properties(argon2 PROPERTIES IMPORTED_LOCATION "${libs}/${ANDROID_ABI}/libargon2.so")

add_library( native-lib
             SHARED
             src/main/cpp/native-lib.cpp )
add_library( encryption
             SHARED
             src/main/cpp/encryption.cpp )

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( log-lib
              log )
target_link_libraries(encryption argon2  ${log-lib})
target_link_libraries(native-lib ${log-lib} )