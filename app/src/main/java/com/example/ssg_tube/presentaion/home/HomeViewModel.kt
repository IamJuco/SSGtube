package com.example.ssg_tube.presentaion.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ssg_tube.network.RetroClient
import com.example.ssg_tube.presentaion.model.ChannelInfo
import com.example.ssg_tube.presentaion.model.VideoModel
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _popularVideo: MutableLiveData<List<VideoModel>> = MutableLiveData()
    val popularVideo: LiveData<List<VideoModel>> get() = _popularVideo

    private val _categoriesVideo = MutableLiveData<List<VideoModel>>()
    val categoriesVideo: LiveData<List<VideoModel>> get() = _categoriesVideo

    private val _channel: MutableLiveData<List<ChannelInfo>> = MutableLiveData()
    val channel: LiveData<List<ChannelInfo>> get() = _channel

    fun getPopularVideo() {
        viewModelScope.launch {
            val response = RetroClient.youTubeRetrofit.videoPopularList(
                part = "snippet",
                chart = "mostPopular",
                regionCode = "KR"
            )
            response.let {
                val popularVideos = it.items.map { item ->
                    VideoModel(
                        thumbnail = item.snippet.thumbnails.default.url,
                        title = item.snippet.title,
                        date = item.snippet.publishedAt,
                        channelIcon = "",
                        channelName = "",
                        description = item.snippet.description,
                        channelId = item.snippet.channelId,
                        videoId = item.id
                    )
                }
                _popularVideo.postValue(popularVideos)
            }
        }
    }

    fun getCategoryVideo(categoryId: String) {
        viewModelScope.launch {
            val response = RetroClient.youTubeRetrofit.videoCategoriesList(
                part = "snippet",
                chart = "mostPopular",
                regionCode = "KR",
                videoCategoryId = categoryId
            )
            response.let {
                val categoryVideos = it.items.map { item ->
                    VideoModel(
                        thumbnail = item.snippet.thumbnails.default.url,
                        title = item.snippet.title,
                        date = item.snippet.publishedAt,
                        channelIcon = "",
                        channelName = "",
                        description = item.snippet.description,
                        channelId = item.snippet.channelId,
                        videoId = item.id
                    )
                }
                _categoriesVideo.postValue(categoryVideos)
                // 채널을 카테고리별로 맞는 채널을 추출하기위해 카테고리에서 추출한 channelId값을 getChannel에 넣어줌
                // 이로써 생성된 카테고리 비디오와 채널이 일치
                val channelId = categoryVideos.map { it.channelId }
                getChannel(channelId)
            }
        }
    }

    private fun getChannel(channelId: List<String>) {
        viewModelScope.launch {
            val response = RetroClient.youTubeRetrofit.videoChannel(
                part = "snippet",
                id = channelId.joinToString(",")
            )
            response.let {
                val channels = it.items.map { item ->
                    ChannelInfo(
                        id = item.id,
                        thumbnail = item.snippet.thumbnails["default"]!!.url
                    )
                }
                _channel.postValue(channels)
            }
        }
    }
}