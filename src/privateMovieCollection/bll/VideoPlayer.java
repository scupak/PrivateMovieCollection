/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateMovieCollection.bll;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author kacpe
 */
public class VideoPlayer
{
    public void playVideo(String filepath) throws IOException
    {
        Desktop.getDesktop().open(new File(filepath));
    }
    
}
