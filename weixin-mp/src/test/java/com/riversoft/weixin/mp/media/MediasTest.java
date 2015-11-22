package com.riversoft.weixin.mp.media;

import com.riversoft.weixin.common.media.Media;
import com.riversoft.weixin.common.media.MediaType;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;

/**
 * Created by exizhai on 10/12/2015.
 */
public class MediasTest {

    @Test
    public void testImage() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("media/image.png");
        Media media = Medias.defaultMedias().upload(MediaType.image, inputStream, "image.png");
        Assert.assertNotNull(media);

        File file = Medias.defaultMedias().download(media.getMediaId());
        Assert.assertTrue(file.exists());
    }

    @Test
    public void testVoice() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("media/test.mp3");
        Media media = Medias.defaultMedias().upload(MediaType.voice, inputStream, "test.mp3");
        Assert.assertNotNull(media);

        File file = Medias.defaultMedias().download(media.getMediaId());
        Assert.assertTrue(file.exists());
    }

}
