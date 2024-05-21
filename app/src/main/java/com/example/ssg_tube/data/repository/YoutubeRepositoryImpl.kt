package com.example.ssg_tube.data.repository

import com.example.ssg_tube.data.model.toDomainChannelModel
import com.example.ssg_tube.data.model.toDomainSearchModel
import com.example.ssg_tube.data.model.toDomainVideoModel
import com.example.ssg_tube.data.remote.YouTubeAPI
import com.example.ssg_tube.presentaion.model.ChannelInfo
import com.example.ssg_tube.presentaion.model.VideoModel
import com.example.ssg_tube.presentaion.repository.YoutubeRepository
import com.example.ssg_tube.presentaion.util.FormatManager

class YoutubeRepositoryImpl(private val apiService: YouTubeAPI) : YoutubeRepository {
    override suspend fun getPopularVideos(): List<VideoModel> {
        val response = apiService.videoPopularList(
            part = "snippet",
            chart = "mostPopular",
            regionCode = "KR"
        )
        return response.items.map { it.toDomainVideoModel()}
    }

    override suspend fun getCategoryVideos(categoryId: String): List<VideoModel> {
        val response = apiService.videoCategoriesList(
            part = "snippet",
            chart = "mostPopular",
            regionCode = "KR",
            videoCategoryId = categoryId
        )
        return response.items.map { it.toDomainVideoModel() }
    }

    override suspend fun getChannel(channelId: List<String>): List<ChannelInfo> {
        val response = apiService.videoChannel(
            part = "snippet",
            id = channelId.joinToString(",")
        )
        return response.items.map { it.toDomainChannelModel() }
    }

    override suspend fun getSearch(query: String, order: String): List<VideoModel> {
        val response = apiService.videoSearch(
            part = "snippet",
            query = query,
            maxResults = 20,
            order = order,
            type = "video",
            videoType = "any"
        )
        return response.items.map { it.toDomainSearchModel() }
    }
}