package com.diego.spotifylist

class SongRepository (val songs:MutableList<Song> = ArrayList()){

    init {
        getDataSongs()
    }

    fun getDataSongs():List<Song> {
        songs.add(Song(100,"Alone","Alan Walker","Electronica","img_cancion1"))
        songs.add(Song(200,"Perdido","Airbag","Rock","img_cancion2"))
        songs.add(Song(300,"Faded","Alan Walker","Electronica","img_cancion3"))
        songs.add(Song(400,"Sabes","Reik","Balada","img_cancion4"))
        songs.add(Song(500,"Lo olvide","Pedro Suarez Vertiz","Rock","img_cancion5"))
        songs.add(Song(600,"Together","Marshmello","Electronica","img_cancion6"))
        songs.add(Song(700,"Cuando tu no estas","El tri","Rock","img_cancion7"))
        songs.add(Song(800,"Nada esta perdido","Afrodisiaco","Balada","img_cancion8"))
        songs.add(Song(900,"There for you","Martin Garrix","Electronica","img_cancion9"))
        songs.add(Song(1000,"November Rain","Guns N'Roses","Rock","img_cancion10"))
        return songs
    }
}