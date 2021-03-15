package com.example.googlemap.room

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.googlemap.R
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
import com.google.android.gms.maps.model.Marker


/**
 * Created by User on 10/2/2017.
 */
class CustomInfoWindowAdapter(private val mContext: Context) : InfoWindowAdapter {
    private val mWindow: View
    private fun rendowWindowText(marker: Marker, view: View) {
        val title = marker.title
        val tvTitle = view.findViewById<View>(R.id.title) as TextView
        if (title != "") {
            tvTitle.text = title
        }
        val snippet = marker.snippet
        val tvSnippet = view.findViewById<View>(R.id.snippet) as TextView
        if (snippet != "") {
            tvSnippet.text = snippet
        }
    }

    override fun getInfoWindow(marker: Marker): View {
        rendowWindowText(marker, mWindow)
        return mWindow
    }

    override fun getInfoContents(marker: Marker): View {
        rendowWindowText(marker, mWindow)
        return mWindow
    }

    init {
        mWindow = LayoutInflater.from(mContext).inflate(R.layout.custom_info_window, null)
    }
}