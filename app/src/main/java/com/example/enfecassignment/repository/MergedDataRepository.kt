package com.example.enfecassignment.repository

import com.example.enfecassignment.api.RetrofitInstance
import com.example.enfecassignment.model.MergedData

class MergedDataRepository {

    private val api = RetrofitInstance.api

    suspend fun getMergedData(): List<MergedData> {
        val posts = api.getPosts()
        val users = api.getUsers()

        return posts.mapNotNull { post ->
            val filteredUser = users.find { user ->
                user.id == post.id
            }

            filteredUser?.let {
                MergedData(
                    title = post.title,
                    name = it.name,
                    email = it.email,
                    companyName = it.company.name,
                    lat = it.address.geo.lat,
                    lng = it.address.geo.lng
                )
            }
        }
    }
}