package com.technado.apiintegration.model

class PhotosModel {
    var id: Int = 0
    var title: String = ""
    var url: String = ""
    var thumbnailUrl: String = ""

    constructor(id: Int, title: String, url: String, thumbnailUrl: String) {
        this.id = id
        this.title = title
        this.url = url
        this.thumbnailUrl = thumbnailUrl
    }
}