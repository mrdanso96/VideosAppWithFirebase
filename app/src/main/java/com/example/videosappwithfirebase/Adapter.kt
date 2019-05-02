package com.example.videosappwithfirebase

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import tcking.github.com.giraffeplayer2.VideoView

class Adapter(data:ArrayList<Lesson>,var context:Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    //constructor
    var data:List<Lesson>

    init {

        this.data = data

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layout = LayoutInflater.from(parent.context).inflate(R.layout.video_item,parent,false)

        return ViewHolder(layout)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val videoItem = data[position]
        holder.title.text = videoItem.title
        holder.desc.text = videoItem.desc
        holder.video.setVideoPath(videoItem.videoUrl)
        holder.download.setOnClickListener {

            //prepare download class
            var download = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
           //prepare video we want to download
            var videoUri = Uri.parse(videoItem.videoUrl)
            var getVideo = DownloadManager.Request(videoUri)
            //show notification that video is downloading
            getVideo.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            download.enqueue(getVideo)

        }

    }

    override fun getItemCount(): Int {

        return data.size

    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item){

        var title:TextView
        var desc:TextView
        var video:VideoView
        var download: Button

        init {

            title = item.findViewById(R.id.video_title)
            desc = item.findViewById(R.id.video_desc)
            video = item.findViewById(R.id.lesson_video)
            download = item.findViewById(R.id.video_download)

        }

    }

}