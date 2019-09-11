package com.example.flickrpublicgallery.model.source

import com.example.flickrpublicgallery.model.response.FlickrFeed
import com.example.flickrpublicgallery.network.service.FlickrGalleryService
import com.google.gson.Gson

/**
 * Created by Mudit Agarwal.
 */
class MockFlickrGalleryDataSource(private val flickrGalleryService: FlickrGalleryService?) : FlickrGalleryDataSource {

    private val SAMPLE_RESPONSE = "{\n" +
            "  \"title\": \"Uploads from everyone\",\n" +
            "  \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/\",\n" +
            "  \"description\": \"\",\n" +
            "  \"modified\": \"2019-09-11T10:09:16Z\",\n" +
            "  \"generator\": \"https:\\/\\/www.flickr.com\",\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"title\": \"Test Photo\",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/ritalang\\/48715687913\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48715687913_a75719e48b_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2019-09-10T13:13:26-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/ritalang\\/\\\">Rita Lang, Nederland<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/ritalang\\/48715687913\\/\\\" title=\\\"Sti kryss til Gladihaug eller Krossane, Nordhordland, Norge,\\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48715687913_a75719e48b_m.jpg\\\" width=\\\"240\\\" height=\\\"180\\\" alt=\\\"Sti kryss til Gladihaug eller Krossane, Nordhordland, Norge,\\\" \\/><\\/a><\\/p> \",\n" +
            "      \"published\": \"2019-09-11T10:09:16Z\",\n" +
            "      \"author\": \"nobody@flickr.com\",\n" +
            "      \"author_id\": \"83772614@N02\",\n" +
            "      \"tags\": \"random\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \" \",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/151659174@N04\\/48715687978\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48715687978_ba1a9e423c_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2018-07-31T14:51:51-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/151659174@N04\\/\\\">khayrialkhayid<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/151659174@N04\\/48715687978\\/\\\" title=\\\" \\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48715687978_ba1a9e423c_m.jpg\\\" width=\\\"180\\\" height=\\\"240\\\" alt=\\\" \\\" \\/><\\/a><\\/p> \",\n" +
            "      \"published\": \"2019-09-11T10:09:17Z\",\n" +
            "      \"author\": \"nobody@flickr.com (\\\"khayrialkhayid\\\")\",\n" +
            "      \"author_id\": \"151659174@N04\",\n" +
            "      \"tags\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \" \",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/184361467@N05\\/48715688273\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48715688273_95a0cab764_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2019-09-08T07:42:30-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/184361467@N05\\/\\\">ngothikimtrinh10.5<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/184361467@N05\\/48715688273\\/\\\" title=\\\" \\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48715688273_95a0cab764_m.jpg\\\" width=\\\"135\\\" height=\\\"240\\\" alt=\\\" \\\" \\/><\\/a><\\/p> \",\n" +
            "      \"published\": \"2019-09-11T10:09:23Z\",\n" +
            "      \"author\": \"nobody@flickr.com (\\\"ngothikimtrinh10.5\\\")\",\n" +
            "      \"author_id\": \"184361467@N05\",\n" +
            "      \"tags\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \" \",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/denisnggraphic\\/48715689588\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48715689588_5b951d98cd_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2019-09-08T14:12:23-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/denisnggraphic\\/\\\">denisngjdphotography<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/denisnggraphic\\/48715689588\\/\\\" title=\\\" \\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48715689588_5b951d98cd_m.jpg\\\" width=\\\"240\\\" height=\\\"160\\\" alt=\\\" \\\" \\/><\\/a><\\/p> \",\n" +
            "      \"published\": \"2019-09-11T10:09:44Z\",\n" +
            "      \"author\": \"nobody@flickr.com (\\\"denisngjdphotography\\\")\",\n" +
            "      \"author_id\": \"79756159@N04\",\n" +
            "      \"tags\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"20190413_Celia and Giac's marriage_325.jpg\",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/17779629@N00\\/48715691023\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48715691023_48ed79f1e4_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2019-04-13T15:55:41-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/17779629@N00\\/\\\">Mike J 17<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/17779629@N00\\/48715691023\\/\\\" title=\\\"20190413_Celia and Giac's marriage_325.jpg\\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48715691023_48ed79f1e4_m.jpg\\\" width=\\\"237\\\" height=\\\"240\\\" alt=\\\"20190413_Celia and Giac's marriage_325.jpg\\\" \\/><\\/a><\\/p> <p>Olympus digital camera<\\/p>\",\n" +
            "      \"published\": \"2019-09-11T10:10:13Z\",\n" +
            "      \"author\": \"nobody@flickr.com (\\\"Mike J 17\\\")\",\n" +
            "      \"author_id\": \"17779629@N00\",\n" +
            "      \"tags\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"174195621025534\",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/amsterdamdna\\/48715691178\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48715691178_b675c22967_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2019-09-11T12:10:16-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/amsterdamdna\\/\\\">Amsterdam DNA<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/amsterdamdna\\/48715691178\\/\\\" title=\\\"174195621025534\\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48715691178_b675c22967_m.jpg\\\" width=\\\"240\\\" height=\\\"180\\\" alt=\\\"174195621025534\\\" \\/><\\/a><\\/p> <p>Amsterdam DNA 174195621025534 | <a href=\\\"http:\\/\\/www.amsterdammuseum.nl\\\" rel=\\\"noreferrer nofollow\\\">www.amsterdammuseum.nl<\\/a><\\/p>\",\n" +
            "      \"published\": \"2019-09-11T10:10:16Z\",\n" +
            "      \"author\": \"nobody@flickr.com (\\\"Amsterdam DNA\\\")\",\n" +
            "      \"author_id\": \"67000021@N04\",\n" +
            "      \"tags\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"FINSPANG SWEDEN\",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/182247995@N08\\/48716018461\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48716018461_86be245af8_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2019-07-17T18:50:56-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/182247995@N08\\/\\\">vittoriomilani.56<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/182247995@N08\\/48716018461\\/\\\" title=\\\"FINSPANG SWEDEN\\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48716018461_86be245af8_m.jpg\\\" width=\\\"134\\\" height=\\\"240\\\" alt=\\\"FINSPANG SWEDEN\\\" \\/><\\/a><\\/p> \",\n" +
            "      \"published\": \"2019-09-11T10:09:16Z\",\n" +
            "      \"author\": \"nobody@flickr.com (\\\"vittoriomilani.56\\\")\",\n" +
            "      \"author_id\": \"182247995@N08\",\n" +
            "      \"tags\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"\\ub9cc 20\\uc138 \\uc774\\uc0c1 \\ub204\\uad6c\\ub098 \\uac00\\ub2a5\\ud569\\ub2c8\\ub2e4 \\ucde8\\uc5c5\\uc900\\ube44\\uc0dd \\/ \\ubb34\\uc9c1\\uc790 \\/ \\uc8fc\\ubd80 \\/ \\ub300\\ud559\\uc0dd \\uc2e0\\uc6a9\\uc870\\ud68c\\uc5c6\\uc774 \\ubb34\\ubc29\\ubb38\\uc73c\\ub85c \\uc785\\uae08\\uc644\\ub8cc \\ub124\\uc774\\ubc84\\uac80\\uc0c9\\ucc3d\\uc5d0 \\uc2a4\\ud53c\\ub4dc\\uc791\\uc5c5\\ub300\\ucd9c https:\\/\\/t.co\\/UFY6261GHJ \\u202a#\\uc791\\uc5c5\\ub300\\ucd9c #\\ubb34\\ubc29\\ubb38\\ub300\\ucd9c #\\uc2e0\\uc6a9\\ub300\\ucd9c #\\ubb34\\uc9c1\\uc790\\ub300\\ucd9c #\\uc2a4\\ud53c\\ub4dc\\uc791\\uc5c5\\ub300\\ucd9c #\\ube44\\ub300\\uba74\\ub300\\ucd9c\\u202c\",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/184096142@N05\\/48716018586\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48716018586_6f72011874_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2019-09-11T03:09:18-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/184096142@N05\\/\\\">speedmoney9999<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/184096142@N05\\/48716018586\\/\\\" title=\\\"\\ub9cc 20\\uc138 \\uc774\\uc0c1 \\ub204\\uad6c\\ub098 \\uac00\\ub2a5\\ud569\\ub2c8\\ub2e4 \\ucde8\\uc5c5\\uc900\\ube44\\uc0dd \\/ \\ubb34\\uc9c1\\uc790 \\/ \\uc8fc\\ubd80 \\/ \\ub300\\ud559\\uc0dd \\uc2e0\\uc6a9\\uc870\\ud68c\\uc5c6\\uc774 \\ubb34\\ubc29\\ubb38\\uc73c\\ub85c \\uc785\\uae08\\uc644\\ub8cc \\ub124\\uc774\\ubc84\\uac80\\uc0c9\\ucc3d\\uc5d0 \\uc2a4\\ud53c\\ub4dc\\uc791\\uc5c5\\ub300\\ucd9c https:\\/\\/t.co\\/UFY6261GHJ \\u202a#\\uc791\\uc5c5\\ub300\\ucd9c #\\ubb34\\ubc29\\ubb38\\ub300\\ucd9c #\\uc2e0\\uc6a9\\ub300\\ucd9c #\\ubb34\\uc9c1\\uc790\\ub300\\ucd9c #\\uc2a4\\ud53c\\ub4dc\\uc791\\uc5c5\\ub300\\ucd9c #\\ube44\\ub300\\uba74\\ub300\\ucd9c\\u202c\\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48716018586_6f72011874_m.jpg\\\" width=\\\"240\\\" height=\\\"240\\\" alt=\\\"\\ub9cc 20\\uc138 \\uc774\\uc0c1 \\ub204\\uad6c\\ub098 \\uac00\\ub2a5\\ud569\\ub2c8\\ub2e4 \\ucde8\\uc5c5\\uc900\\ube44\\uc0dd \\/ \\ubb34\\uc9c1\\uc790 \\/ \\uc8fc\\ubd80 \\/ \\ub300\\ud559\\uc0dd \\uc2e0\\uc6a9\\uc870\\ud68c\\uc5c6\\uc774 \\ubb34\\ubc29\\ubb38\\uc73c\\ub85c \\uc785\\uae08\\uc644\\ub8cc \\ub124\\uc774\\ubc84\\uac80\\uc0c9\\ucc3d\\uc5d0 \\uc2a4\\ud53c\\ub4dc\\uc791\\uc5c5\\ub300\\ucd9c https:\\/\\/t.co\\/UFY6261GHJ \\u202a#\\uc791\\uc5c5\\ub300\\ucd9c #\\ubb34\\ubc29\\ubb38\\ub300\\ucd9c #\\uc2e0\\uc6a9\\ub300\\ucd9c #\\ubb34\\uc9c1\\uc790\\ub300\\ucd9c #\\uc2a4\\ud53c\\ub4dc\\uc791\\uc5c5\\ub300\\ucd9c #\\ube44\\ub300\\uba74\\ub300\\ucd9c\\u202c\\\" \\/><\\/a><\\/p> <p>via Instagram <a href=\\\"https:\\/\\/ift.tt\\/306j3vM\\\" rel=\\\"noreferrer nofollow\\\">ift.tt\\/306j3vM<\\/a><\\/p>\",\n" +
            "      \"published\": \"2019-09-11T10:09:18Z\",\n" +
            "      \"author\": \"nobody@flickr.com (\\\"speedmoney9999\\\")\",\n" +
            "      \"author_id\": \"184096142@N05\",\n" +
            "      \"tags\": \"\\uc791\\uc5c5\\ub300\\ucd9c \\uc2a4\\ud53c\\ub4dc\\uc791\\uc5c5\\ub300\\ucd9c\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Lavash bread maker, Armenia\",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/ejwwest\\/48716018741\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48716018741_4a60e93175_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2019-09-06T12:32:49-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/ejwwest\\/\\\">ejwwest<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/ejwwest\\/48716018741\\/\\\" title=\\\"Lavash bread maker, Armenia\\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48716018741_4a60e93175_m.jpg\\\" width=\\\"240\\\" height=\\\"240\\\" alt=\\\"Lavash bread maker, Armenia\\\" \\/><\\/a><\\/p> \",\n" +
            "      \"published\": \"2019-09-11T10:09:20Z\",\n" +
            "      \"author\": \"nobody@flickr.com (\\\"ejwwest\\\")\",\n" +
            "      \"author_id\": \"7216770@N04\",\n" +
            "      \"tags\": \"mountains georgia tbilisi armenia yerevan caucasus garni kotaykregion\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Unusual for me to be out on a Tuesday night, but @blamiremusic just get better every time. Great sound on the main stage at @theclunynewcastle too, very powerful.\",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/pauljw\\/48716018761\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48716018761_180fe9bdab_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2019-09-11T11:09:20-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/pauljw\\/\\\">Paul J White<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/pauljw\\/48716018761\\/\\\" title=\\\"Unusual for me to be out on a Tuesday night, but @blamiremusic just get better every time. Great sound on the main stage at @theclunynewcastle too, very powerful.\\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48716018761_180fe9bdab_m.jpg\\\" width=\\\"240\\\" height=\\\"240\\\" alt=\\\"Unusual for me to be out on a Tuesday night, but @blamiremusic just get better every time. Great sound on the main stage at @theclunynewcastle too, very powerful.\\\" \\/><\\/a><\\/p> <p>View on Instagram <a href=\\\"https:\\/\\/ift.tt\\/2LCvIB6\\\" rel=\\\"noreferrer nofollow\\\">ift.tt\\/2LCvIB6<\\/a><\\/p>\",\n" +
            "      \"published\": \"2019-09-11T10:09:20Z\",\n" +
            "      \"author\": \"nobody@flickr.com (\\\"Paul J White\\\")\",\n" +
            "      \"author_id\": \"24808396@N00\",\n" +
            "      \"tags\": \"instagram ifttt\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Renault 18 GTS - Santiago, Chile\",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/riveranotario\\/48716021656\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48716021656_166f4b35bb_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2019-09-10T08:57:57-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/riveranotario\\/\\\">RiveraNotario<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/riveranotario\\/48716021656\\/\\\" title=\\\"Renault 18 GTS - Santiago, Chile\\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48716021656_166f4b35bb_m.jpg\\\" width=\\\"240\\\" height=\\\"160\\\" alt=\\\"Renault 18 GTS - Santiago, Chile\\\" \\/><\\/a><\\/p> \",\n" +
            "      \"published\": \"2019-09-11T10:10:08Z\",\n" +
            "      \"author\": \"nobody@flickr.com (\\\"RiveraNotario\\\")\",\n" +
            "      \"author_id\": \"55665672@N02\",\n" +
            "      \"tags\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"White thigh high overknee boots\",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/165049484@N07\\/48716021761\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48716021761_03da0cb6bd_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2019-06-16T17:58:56-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/165049484@N07\\/\\\">ladyagataboots<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/165049484@N07\\/48716021761\\/\\\" title=\\\"White thigh high overknee boots\\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48716021761_03da0cb6bd_m.jpg\\\" width=\\\"240\\\" height=\\\"192\\\" alt=\\\"White thigh high overknee boots\\\" \\/><\\/a><\\/p> <p>White thigh high overknee boots <a href=\\\"https:\\/\\/ladyagata.com\\/white-thigh-high-overknee-boots\\/\\\" rel=\\\"noreferrer nofollow\\\">ladyagata.com\\/white-thigh-high-overknee-boots\\/<\\/a><\\/p>\",\n" +
            "      \"published\": \"2019-09-11T10:10:09Z\",\n" +
            "      \"author\": \"nobody@flickr.com (\\\"ladyagataboots\\\")\",\n" +
            "      \"author_id\": \"165049484@N07\",\n" +
            "      \"tags\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Erdm\\u00e4nnchen (Lat. Suricata suricatta) - Pelle ohne Schwanz\",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/toms-fotokiste\\/48716021926\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48716021926_1556634afa_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2014-10-28T12:34:46-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/toms-fotokiste\\/\\\">Tom's Fotokisten (thanks vor over 14 Mio. views)<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/toms-fotokiste\\/48716021926\\/\\\" title=\\\"Erdm\\u00e4nnchen (Lat. Suricata suricatta) - Pelle ohne Schwanz\\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48716021926_1556634afa_m.jpg\\\" width=\\\"240\\\" height=\\\"160\\\" alt=\\\"Erdm\\u00e4nnchen (Lat. Suricata suricatta) - Pelle ohne Schwanz\\\" \\/><\\/a><\\/p> <p>Zoo Wuppertal<\\/p>\",\n" +
            "      \"published\": \"2019-09-11T10:10:12Z\",\n" +
            "      \"author\": \"nobody@flickr.com (\\\"Tom's Fotokisten (thanks vor over 14 Mio. views)\\\")\",\n" +
            "      \"author_id\": \"123597211@N03\",\n" +
            "      \"tags\": \"1804 afrika anselmega\\u00ebtandesmarest erdm\\u00e4nnchen mangusten meerkat pelleohneschwanz raubtiere scharrtier stokstaartje suricata suricatasuricatta suricate surikate s\\u00e4ugetiere zoowuppertal \\u30df\\u30fc\\u30a2\\u30ad\\u30e3\\u30c3\\u30c8 \\u72d0\\u7374\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"First in Date Taken\",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/kidka\\/48716021976\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48716021976_f8b6e47d95_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2019-09-11T13:10:14-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/kidka\\/\\\">kidka<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/kidka\\/48716021976\\/\\\" title=\\\"\\u041e\\u0447\\u0435\\u043d\\u044c \\u043b\\u044e\\u0431\\u043b\\u044e \\u0442\\u0430\\u043a\\u043e\\u0435. \\u0410 \\u0435\\u0449\\u0451 \\u0432 \\u043f\\u043e\\u0434\\u044a\\u0435\\u0437\\u0434\\u0435 \\u0437\\u0435\\u043b\\u0435\\u043d\\u044b\\u0435 \\u0441\\u0442\\u0435\\u043d\\u044b \\u043f\\u0435\\u0440\\u0435\\u043a\\u0440\\u0430\\u0441\\u0438\\u043b\\u0438 \\u0432 \\u0436\\u0435\\u043b\\u0442\\u044b\\u0435, \\u0434\\u0443\\u0448\\u0430 \\u0440\\u0430\\u0434\\u0443\\u0435\\u0442\\u0441\\u044f.\\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48716021976_f8b6e47d95_m.jpg\\\" width=\\\"240\\\" height=\\\"240\\\" alt=\\\"\\u041e\\u0447\\u0435\\u043d\\u044c \\u043b\\u044e\\u0431\\u043b\\u044e \\u0442\\u0430\\u043a\\u043e\\u0435. \\u0410 \\u0435\\u0449\\u0451 \\u0432 \\u043f\\u043e\\u0434\\u044a\\u0435\\u0437\\u0434\\u0435 \\u0437\\u0435\\u043b\\u0435\\u043d\\u044b\\u0435 \\u0441\\u0442\\u0435\\u043d\\u044b \\u043f\\u0435\\u0440\\u0435\\u043a\\u0440\\u0430\\u0441\\u0438\\u043b\\u0438 \\u0432 \\u0436\\u0435\\u043b\\u0442\\u044b\\u0435, \\u0434\\u0443\\u0448\\u0430 \\u0440\\u0430\\u0434\\u0443\\u0435\\u0442\\u0441\\u044f.\\\" \\/><\\/a><\\/p> <p>View on Instagram <a href=\\\"https:\\/\\/ift.tt\\/34GAx5s\\\" rel=\\\"noreferrer nofollow\\\">ift.tt\\/34GAx5s<\\/a><\\/p>\",\n" +
            "      \"published\": \"2019-09-11T10:10:14Z\",\n" +
            "      \"author\": \"nobody@flickr.com (\\\"kidka\\\")\",\n" +
            "      \"author_id\": \"7171899@N04\",\n" +
            "      \"tags\": \"instagram ifttt\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \" \",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/tigertrail\\/48716190622\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48716190622_0b4fdff306_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2019-09-10T12:41:06-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/tigertrail\\/\\\">Tiger on Trail<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/tigertrail\\/48716190622\\/\\\" title=\\\" \\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48716190622_0b4fdff306_m.jpg\\\" width=\\\"240\\\" height=\\\"135\\\" alt=\\\" \\\" \\/><\\/a><\\/p> \",\n" +
            "      \"published\": \"2019-09-11T10:09:15Z\",\n" +
            "      \"author\": \"nobody@flickr.com (\\\"Tiger on Trail\\\")\",\n" +
            "      \"author_id\": \"150484527@N06\",\n" +
            "      \"tags\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Photo no 10: Elie Buzyn, rescap\\u00e9 del Shoah. RJ Rosh Hashoah septembre 2019\",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/169486962@N02\\/48716191087\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48716191087_11a1faffff_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2019-09-11T03:09:24-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/169486962@N02\\/\\\">elkaim.michel2019<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/169486962@N02\\/48716191087\\/\\\" title=\\\"Photo no 10: Elie Buzyn, rescap\\u00e9 del Shoah. RJ Rosh Hashoah septembre 2019\\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48716191087_11a1faffff_m.jpg\\\" width=\\\"240\\\" height=\\\"160\\\" alt=\\\"Photo no 10: Elie Buzyn, rescap\\u00e9 del Shoah. RJ Rosh Hashoah septembre 2019\\\" \\/><\\/a><\\/p> \",\n" +
            "      \"published\": \"2019-09-11T10:09:24Z\",\n" +
            "      \"author\": \"nobody@flickr.com (\\\"elkaim.michel2019\\\")\",\n" +
            "      \"author_id\": \"169486962@N02\",\n" +
            "      \"tags\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"DSC_2990-1\",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/ross0005\\/48716191702\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48716191702_c2a46f837a_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2019-09-10T20:21:11-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/ross0005\\/\\\">rossi 500<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/ross0005\\/48716191702\\/\\\" title=\\\"DSC_2990-1\\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48716191702_c2a46f837a_m.jpg\\\" width=\\\"240\\\" height=\\\"161\\\" alt=\\\"DSC_2990-1\\\" \\/><\\/a><\\/p> \",\n" +
            "      \"published\": \"2019-09-11T10:09:34Z\",\n" +
            "      \"author\": \"nobody@flickr.com (\\\"rossi 500\\\")\",\n" +
            "      \"author_id\": \"67118444@N05\",\n" +
            "      \"tags\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"KCL_7191.jpg\",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/25085074@N02\\/48716193752\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48716193752_df3f0eb03f_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2019-08-11T17:24:13-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/25085074@N02\\/\\\">klonnq<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/25085074@N02\\/48716193752\\/\\\" title=\\\"KCL_7191.jpg\\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48716193752_df3f0eb03f_m.jpg\\\" width=\\\"240\\\" height=\\\"160\\\" alt=\\\"KCL_7191.jpg\\\" \\/><\\/a><\\/p> \",\n" +
            "      \"published\": \"2019-09-11T10:10:09Z\",\n" +
            "      \"author\": \"nobody@flickr.com (\\\"klonnq\\\")\",\n" +
            "      \"author_id\": \"25085074@N02\",\n" +
            "      \"tags\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"2019-09-11_12-09-43\",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/156825609@N04\\/48716193887\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48716193887_f50970488b_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2019-09-11T10:31:27-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/156825609@N04\\/\\\">ale_beed<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/156825609@N04\\/48716193887\\/\\\" title=\\\"2019-09-11_12-09-43\\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48716193887_f50970488b_m.jpg\\\" width=\\\"180\\\" height=\\\"240\\\" alt=\\\"2019-09-11_12-09-43\\\" \\/><\\/a><\\/p> \",\n" +
            "      \"published\": \"2019-09-11T10:10:12Z\",\n" +
            "      \"author\": \"nobody@flickr.com (\\\"ale_beed\\\")\",\n" +
            "      \"author_id\": \"156825609@N04\",\n" +
            "      \"tags\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"First in Published Date\",\n" +
            "      \"link\": \"https:\\/\\/www.flickr.com\\/photos\\/184392575@N04\\/48716194132\\/\",\n" +
            "      \"media\": {\n" +
            "        \"m\": \"https:\\/\\/live.staticflickr.com\\/65535\\/48716194132_5c21421128_m.jpg\"\n" +
            "      },\n" +
            "      \"date_taken\": \"2019-06-01T23:24:26-08:00\",\n" +
            "      \"description\": \" <p><a href=\\\"https:\\/\\/www.flickr.com\\/people\\/184392575@N04\\/\\\">etiennebourdin<\\/a> posted a photo:<\\/p> <p><a href=\\\"https:\\/\\/www.flickr.com\\/photos\\/184392575@N04\\/48716194132\\/\\\" title=\\\"20190601_232426-01\\\"><img src=\\\"https:\\/\\/live.staticflickr.com\\/65535\\/48716194132_5c21421128_m.jpg\\\" width=\\\"180\\\" height=\\\"240\\\" alt=\\\"20190601_232426-01\\\" \\/><\\/a><\\/p> \",\n" +
            "      \"published\": \"2019-09-11T10:10:17Z\",\n" +
            "      \"author\": \"nobody@flickr.com (\\\"etiennebourdin\\\")\",\n" +
            "      \"author_id\": \"184392575@N04\",\n" +
            "      \"tags\": \"\"\n" +
            "    }\n" +
            "  ]\n" +
            "}"

    override suspend fun getPhotos(tag: String): FlickrFeed {
        return Gson().fromJson(SAMPLE_RESPONSE, FlickrFeed::class.java)
    }
}