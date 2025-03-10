// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package com.example.test_plugin

import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler

/**
 * This plugin handles the native side of the integration tests in
 * example/integration_test/.
 */
class TestPlugin: FlutterPlugin, HostIntegrationCoreApi {
  var flutterApi: FlutterIntegrationCoreApi? = null

  override fun onAttachedToEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    HostIntegrationCoreApi.setUp(binding.getBinaryMessenger(), this)
    flutterApi = FlutterIntegrationCoreApi(binding.getBinaryMessenger())
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
  }

  // HostIntegrationCoreApi

  override fun noop() {
  }

  override fun echoAllTypes(everything: AllTypes): AllTypes {
    return everything
  }

  override fun echoAllNullableTypes(everything: AllNullableTypes?): AllNullableTypes? {
    return everything
  }

  override fun throwError(): Object? {
    throw Exception("An error");
  }

  override fun throwErrorFromVoid() {
    throw Exception("An error");
  }

  override fun echoInt(anInt: Long): Long {
    return anInt
  }

  override fun echoDouble(aDouble: Double): Double {
    return aDouble
  }

  override fun echoBool(aBool: Boolean): Boolean {
    return aBool
  }

  override fun echoString(aString: String): String {
    return aString
  }

  override fun echoUint8List(aUint8List: ByteArray): ByteArray {
    return aUint8List
  }

  override fun echoObject(anObject: Any): Any {
    return anObject
  }

  override fun echoList(aList: List<Any?>): List<Any?> {
    return aList
  }

  override fun echoMap(aMap: Map<String?, Any?>): Map<String?, Any?> {
    return aMap
  }

  override fun extractNestedNullableString(wrapper: AllNullableTypesWrapper): String? {
    return wrapper.values.aNullableString
  }

  override fun createNestedNullableString(nullableString: String?): AllNullableTypesWrapper {
    return AllNullableTypesWrapper(AllNullableTypes(aNullableString = nullableString))
  }

  override fun sendMultipleNullableTypes(aNullableBool: Boolean?, aNullableInt: Long?, aNullableString: String?): AllNullableTypes {
    return AllNullableTypes(aNullableBool = aNullableBool, aNullableInt = aNullableInt, aNullableString = aNullableString)
  }

  override fun echoNullableInt(aNullableInt: Long?): Long? {
    return aNullableInt
  }

  override fun echoNullableDouble(aNullableDouble: Double?): Double? {
    return aNullableDouble
  }

  override fun echoNullableBool(aNullableBool: Boolean?): Boolean? {
    return aNullableBool
  }

  override fun echoNullableString(aNullableString: String?): String? {
    return aNullableString
  }

  override fun echoNullableUint8List(aNullableUint8List: ByteArray?): ByteArray? {
    return aNullableUint8List
  }

  override fun echoNullableObject(aNullableObject: Any?): Any? {
    return aNullableObject
  }

  override fun echoNullableList(aNullableList: List<Any?>?): List<Any?>? {
    return aNullableList
  }

  override fun echoNullableMap(aNullableMap: Map<String?, Any?>?): Map<String?, Any?>? {
    return aNullableMap
  }
  override fun noopAsync(callback: (Result<Unit>) -> Unit) {
    callback(Result.success(Unit))
  }

  override fun throwAsyncError(callback: (Result<Any?>) -> Unit) {
    callback(Result.failure(Exception("except")))
  }

  override fun throwAsyncErrorFromVoid(callback: (Result<Unit>) -> Unit) {
    callback(Result.failure(Exception("except")))
  }

  override fun echoAsyncAllTypes(everything: AllTypes, callback: (Result<AllTypes>) -> Unit) {
    callback(Result.success(everything))
  }

  override fun echoAsyncNullableAllNullableTypes(everything: AllNullableTypes?, callback: (Result<AllNullableTypes?>) -> Unit) {
    callback(Result.success(everything))
  }

  override fun echoAsyncInt(anInt: Long, callback: (Result<Long>) -> Unit) {
    callback(Result.success(anInt))
  }

  override fun echoAsyncDouble(aDouble: Double, callback: (Result<Double>) -> Unit) {
    callback(Result.success(aDouble))
  }

  override fun echoAsyncBool(aBool: Boolean, callback: (Result<Boolean>) -> Unit) {
    callback(Result.success(aBool))
  }

  override fun echoAsyncString(aString: String, callback: (Result<String>) -> Unit) {
    callback(Result.success(aString))
  }

  override fun echoAsyncUint8List(aUint8List: ByteArray, callback: (Result<ByteArray>) -> Unit) {
    callback(Result.success(aUint8List))
  }

  override fun echoAsyncObject(anObject: Any, callback: (Result<Any>) -> Unit) {
    callback(Result.success(anObject))
  }

  override fun echoAsyncList(aList: List<Any?>, callback: (Result<List<Any?>>) -> Unit) {
    callback(Result.success(aList))
  }

  override fun echoAsyncMap(aMap: Map<String?, Any?>, callback: (Result<Map<String?, Any?>>) -> Unit) {
    callback(Result.success(aMap))
  }
  
  override fun echoAsyncNullableInt(anInt: Long?, callback: (Result<Long?>) -> Unit) {
    callback(Result.success(anInt))
  }

  override fun echoAsyncNullableDouble(aDouble: Double?, callback: (Result<Double?>) -> Unit) {
    callback(Result.success(aDouble))
  }

  override fun echoAsyncNullableBool(aBool: Boolean?, callback: (Result<Boolean?>) -> Unit) {
    callback(Result.success(aBool))
  }

  override fun echoAsyncNullableString(aString: String?, callback: (Result<String?>) -> Unit) {
    callback(Result.success(aString))
  }

  override fun echoAsyncNullableUint8List(aUint8List: ByteArray?, callback: (Result<ByteArray?>) -> Unit) {
    callback(Result.success(aUint8List))
  }

  override fun echoAsyncNullableObject(anObject: Any?, callback: (Result<Any?>) -> Unit) {
    callback(Result.success(anObject))
  }

  override fun echoAsyncNullableList(aList: List<Any?>?, callback: (Result<List<Any?>?>) -> Unit) {
    callback(Result.success(aList))
  }

  override fun echoAsyncNullableMap(aMap: Map<String?, Any?>?, callback: (Result<Map<String?, Any?>?>) -> Unit) {
    callback(Result.success(aMap))
  }

  override fun callFlutterNoop(callback: (Result<Unit>) -> Unit) {
    flutterApi!!.noop() { callback(Result.success(Unit)) }
  }
  
  override fun callFlutterThrowError(callback: (Result<Any?>) -> Unit) {
    // TODO: (tarrinneal) Once flutter api error handling is added, complete these tests.
    // See issue https://github.com/flutter/flutter/issues/118243
  }
  override fun callFlutterThrowErrorFromVoid(callback: (Result<Unit>) -> Unit) {
    // TODO: (tarrinneal) Once flutter api error handling is added, complete these tests.
    // See issue https://github.com/flutter/flutter/issues/118243
  }

  override fun callFlutterEchoAllTypes(everything: AllTypes, callback: (Result<AllTypes>) -> Unit) {
    flutterApi!!.echoAllTypes(everything) { echo -> callback(Result.success(echo)) }
  }

  override fun callFlutterSendMultipleNullableTypes(
    aNullableBool: Boolean?, 
    aNullableInt: Long?, 
    aNullableString: String?, 
    callback: (Result<AllNullableTypes>) -> Unit
  ) {
    flutterApi!!.sendMultipleNullableTypes(aNullableBool, aNullableInt, aNullableString) {
      echo -> callback(Result.success(echo))
    }
  }

  override fun callFlutterEchoBool(aBool: Boolean, callback: (Result<Boolean>) -> Unit) {
    flutterApi!!.echoBool(aBool) { echo -> callback(Result.success(echo)) }
  }

  override fun callFlutterEchoInt(anInt: Long, callback: (Result<Long>) -> Unit) {
    flutterApi!!.echoInt(anInt) { echo -> callback(Result.success(echo)) }
  }

  override fun callFlutterEchoDouble(aDouble: Double, callback: (Result<Double>) -> Unit) {
    flutterApi!!.echoDouble(aDouble) { echo -> callback(Result.success(echo)) }
  }

  override fun callFlutterEchoString(aString: String, callback: (Result<String>) -> Unit) {
    flutterApi!!.echoString(aString) { echo -> callback(Result.success(echo)) }
  }

  override fun callFlutterEchoUint8List(aList: ByteArray, callback: (Result<ByteArray>) -> Unit) {
    flutterApi!!.echoUint8List(aList) { echo -> callback(Result.success(echo)) }
  }

  override fun callFlutterEchoList(aList: List<Any?>, callback: (Result<List<Any?>>) -> Unit){
    flutterApi!!.echoList(aList) { echo -> callback(Result.success(echo)) }
  }

  override fun callFlutterEchoMap(aMap: Map<String?, Any?>, callback: (Result<Map<String?, Any?>>) -> Unit) {
    flutterApi!!.echoMap(aMap) { echo -> callback(Result.success(echo)) }
  }

  override fun callFlutterEchoNullableBool(aBool: Boolean?, callback: (Result<Boolean?>) -> Unit) {
    flutterApi!!.echoNullableBool(aBool) { echo -> callback(Result.success(echo)) }
  }

  override fun callFlutterEchoNullableInt(anInt: Long?, callback: (Result<Long?>) -> Unit) {
    flutterApi!!.echoNullableInt(anInt) { echo -> callback(Result.success(echo)) }
  }

  override fun callFlutterEchoNullableDouble(aDouble: Double?, callback: (Result<Double?>) -> Unit) {
    flutterApi!!.echoNullableDouble(aDouble) { echo -> callback(Result.success(echo)) }
  }

  override fun callFlutterEchoNullableString(aString: String?, callback: (Result<String?>) -> Unit) {
    flutterApi!!.echoNullableString(aString) { echo -> callback(Result.success(echo)) }
  }

  override fun callFlutterEchoNullableUint8List(aList: ByteArray?, callback: (Result<ByteArray?>) -> Unit) {
    flutterApi!!.echoNullableUint8List(aList) { echo -> callback(Result.success(echo)) }
  }

  override fun callFlutterEchoNullableList(aList: List<Any?>?, callback: (Result<List<Any?>?>) -> Unit) {
    flutterApi!!.echoNullableList(aList) { echo -> callback(Result.success(echo)) }
  }

  override fun callFlutterEchoNullableMap(aMap: Map<String?, Any?>?, callback: (Result<Map<String?, Any?>?>) -> Unit) {
    flutterApi!!.echoNullableMap(aMap) { echo -> callback(Result.success(echo)) }
  }

}
