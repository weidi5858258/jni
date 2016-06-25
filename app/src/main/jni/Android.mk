
# 在一个Android.mk中可以生成多个可执行程序、动态库和静态库。
# :=是赋值的意思，$是引用某变量的值
# LOCAL_C_INCLUDES 			加入所需要包含的头文件路径
# LOCAL_STATIC_LIBRARIES	加入所需要链接的静态库（*.a）的名称
# LOCAL_SHARED_LIBRARIES	加入所需要链接的动态库（*.so）的名称

# BUILD_EXECUTABLE    	表示编译一个可执行程序		out/target/product/generic/obj/EXECUTABLE
# BUILD_SHARED_LIBRARY	表示编译一个共享库		out/target/product/generic/obj/SHARED_LIBRARY
# BUILD_STATIC_LIBRARY	表示编译一个静态库		out/target/product/generic/obj/STATIC_LIBRARY
#
# 每个模块的目标文件夹分别为：
# 可执行程序：XXX_intermediates
# 动态库： 	 XXX_shared_intermediates
# 静态库： 	 XXX_static_intermediates
#
# 在Android.mk文件中，还可以指定最后的目标安装路径，用LOCAL_MODULE_PATH和LOCAL_UNSTRIPPED_PATH来指定
# 不同的文件系统路径用以下的宏进行选择：
# TARGET_ROOT_OUT：表示根文件系统
# TARGET_OUT：	   表示system文件系统
# TARGET_OUT_DATA：表示data文件系统
# 用法如：LOCAL_MODULE_PATH:=$(TARGET_ROOT_OUT)

####################################################################################################

# 编译动态库的模板（android中使用）
# 获取当前目录
LOCAL_PATH := $(call my-dir)

# 清除一些变量
include $(CLEAR_VARS)

# LOCAL_SRC_FILES  加入源文件路径
# LOCAL_MODULE     表示模块最终的名称
LOCAL_SRC_FILES := hello-jni.c
LOCAL_MODULE    := hello-jni

# libhello-jni.so需要引用的库libdl.so加载动态函数需要，liblog.so日志打印需要，默认在system/lib目录下
LOCAL_LDLIBS    := -ldl -llog

#LOCAL_C_INCLUDES :=
#LOCAL_STATIC_LIBRARIES :=
#LOCAL_SHARED_LIBRARIES :=

# 生成动态库libhello-jni.so
include $(BUILD_SHARED_LIBRARY)

# 编译应用程序的模板
LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_SRC_FILES := main.c
LOCAL_MODULE    := test_exe

include $(BUILD_EXECUTABLE)

# 编译静态库的模板
LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_SRC_FILES := helloworld.c
LOCAL_MODULE    := libtest_static

include $(BUILD_STATIC_LIBRARY)