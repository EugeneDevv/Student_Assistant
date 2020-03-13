package com.eugene.student_assistant.web

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.eugene.student_assistant.R
import kotlinx.android.synthetic.main.activity_school_web.*

class SchoolWebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_web)

        val context = this

        schoolWebView.webViewClient = MyWebViewClient()

        schoolWebView.settings.javaScriptEnabled = true

        schoolWebView.loadUrl("http://wwww.uoeld.ac.ke")

        btnGoBack2.setOnClickListener {
            if (schoolWebView.canGoBack())
                schoolWebView.goBack()
            else
                Toast.makeText(this, "No History Available", Toast.LENGTH_SHORT).show()
        }

        btnGoForward2.setOnClickListener {
            if (schoolWebView.canGoForward())
                schoolWebView.goForward()
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
