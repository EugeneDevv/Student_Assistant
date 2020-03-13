package com.eugene.student_assistant.web

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.eugene.student_assistant.R
import kotlinx.android.synthetic.main.activity_portal_web.*

class PortalWebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portal_web)

        val context = this

        portalWebView.webViewClient = MyWebViewClient()

        portalWebView.settings.javaScriptEnabled = true

        portalWebView.loadUrl("http://portal.uoeld.ac.ke")

        btnGoBack.setOnClickListener {
            if (portalWebView.canGoBack())
                portalWebView.goBack()
            else
                Toast.makeText(this, "No History Available", Toast.LENGTH_SHORT).show()
        }

        btnGoForward.setOnClickListener {
            if (portalWebView.canGoForward())
                portalWebView.goForward()
            else
                Toast.makeText(context, "No History Available", Toast.LENGTH_SHORT).show()
        }
    }

    class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            view?.loadUrl(request?.url.toString())
            return true
        }
    }
}