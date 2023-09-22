package com.example.demo_flutter

import ai.protectt.app.security.common.helper.SDKConstants
import ai.protectt.app.security.main.AppProtecttInteractor
import ai.protectt.app.security.main.AppProtecttInteractor.Companion.setClientInfo
import ai.protectt.app.security.shouldnotobfuscated.dto.ClientInfo
import android.app.Application
import android.util.Log


class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        AppProtecttInteractor.registerCallbackActivities(this)
        val clientInfo = ClientInfo()
        clientInfo.clientId = 2 //client id
        clientInfo.channelId = 2026 //channel id
        clientInfo.appName =  "A2 Internal Test";//package name
        clientInfo.packageName = "ai.protectt.app.security" //application name
        clientInfo.password = "f89e2d201392414a91a89fc5e0f82026" //channel id
        clientInfo.channelLicenseKey = "5b5320b7-0f3f-40bd-a85e-a36aa2402026"; //activation key
        clientInfo.mainAppVersionCode = "${BuildConfig.VERSION_CODE}"
        clientInfo.appVersionName = BuildConfig.VERSION_NAME
        setClientInfo(clientInfo)
        /*val clientInfo = ClientInfo()
        clientInfo.clientId = 21 //client id
        clientInfo.channelId = 2104 //channel id
        clientInfo.appName = "iris by YES BANK UAT" //package name
        clientInfo.packageName = "com.yesmidasapp"//application name
        clientInfo.password = "f89e2d511210414a91a89fc2e0f82104" //channel id
        clientInfo.channelLicenseKey = "10090cb7-27ba-4f5d-8b42-e92a4UAT2104"//activation key
        clientInfo.mainAppVersionCode = "${BuildConfig.VERSION_CODE}"
        clientInfo.appVersionName = BuildConfig.VERSION_NAME
        setClientInfo(clientInfo)*/
        /**========================= end prod test configuration ==========================*/
        AppProtecttInteractor(this).initAppProtectt(
            "SplashScreen",
            R.layout.alert_layout,
            R.mipmap.ic_launcher,
            R.style.transperent_style,
            BuildConfig.BUILD_TYPE,
            SDKConstants.BOTTOMSHEET_DIALOG
        )
        Log.i("FlutterTrust","${AppProtecttInteractor.Companion.getTrust(this)}")

    }
}