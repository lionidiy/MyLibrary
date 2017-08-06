import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 常用排序算法集合
 */
public class Main
{

    private static final int FONT_HEIGHT = 12;
    private static final int TITLE_FONT_HEIGHT = 28;


    public static BufferedImage drawTranslucentStringPic(int width, int height, String drawStr)
    {
        try
        {
            BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D gd = buffImg.createGraphics();

            //设置透明  start
            buffImg = gd.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.OPAQUE);
            gd = buffImg.createGraphics();
            //设置背景设
            gd.setBackground(new Color(255, 255, 255));
            gd.clearRect(0, 0, width, height);
            //标题
            //设置画笔颜色
            gd.setPaint(new Color(0, 0, 0));
            //===========================================
            //设置字体
            gd.setFont(new Font("微软雅黑", Font.PLAIN, TITLE_FONT_HEIGHT));
            //显示字体
            gd.drawString(drawStr, width / 2 - TITLE_FONT_HEIGHT * drawStr.length() / 2, 45);
            //=============================================
            //图例
            gd.setFont(new Font("微软雅黑", Font.TRUETYPE_FONT, FONT_HEIGHT));
            gd.drawRect(100, 70, 340, 40);

            gd.setBackground(new Color(0, 255, 0));
            gd.clearRect(110, 75, 10, 10);
            gd.drawString(drawStr, 125, 85);
            gd.setBackground(new Color(255, 0, 0));
            gd.clearRect(280, 75, 10, 10);
            gd.drawString(drawStr, 295, 85);
            gd.setBackground(new Color(0, 0, 255));
            gd.clearRect(110, 95, 10, 10);
            gd.drawString(drawStr, 125, 105);

            gd.drawLine(60, 120, 60, 540);
            for (int i = 0; i < 6; i++)
            {
                int y1 = 120 + i * 70;
                gd.drawLine(55, y1, 65, y1);
                gd.drawString(String.valueOf(300 - i * 50), 35, y1 + 5);
                for (int j = 0; j < 5; j++)
                {
                    int y2 = j * 14 + y1;
                    gd.drawLine(58, y2, 62, y2);
                }
            }

            gd.drawLine(60, 540, 510, 540);

            for (int i = 1; i <= 10; i++)
            {
                int x1 = 60 + 45 * i;
                gd.drawLine(x1, 545, x1, 535);
                gd.drawString(String.valueOf(100 * i), x1 - 12, 557);
                for (int j = 1; j < 5; j++)
                {
                    int x2 = j * 9 + x1 - 45;
                    gd.drawLine(x2, 542, x2, 538);
                }
            }
            //gd.drawRect();
            gd.dispose();
            return buffImg;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * 标题
     *
     * @param width   width
     * @param drawStr drawStr
     * @param gd      gd
     */
    private static void drawTitle(int width, String drawStr, Graphics2D gd)
    {

    }


    public static void main(String[] args)
    {
        BufferedImage imgMap = drawTranslucentStringPic(543, 600, "欢迎访问我的博客");
        File imgFile = new File("D://www.cxyapi.com.png");
        try
        {
            ImageIO.write(imgMap, "PNG", imgFile);
            //
            //int width = 128;
            //int height = 64;
            //// 创建BufferedImage对象
            //Font font = new Font("宋体", Font.PLAIN, 16);
            //BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            //// 获取Graphics2D
            //Graphics2D g2d = image.createGraphics();
            //// 画图
            //g2d.setBackground(new Color(255, 255, 255));
            ////g2d.setPaint(new Color(0,0,0));
            //g2d.clearRect(0, 0, width, height);
            //g2d.setBackground(new Color(255, 255, 000));
            //g2d.setPaint(new Color(0, 0, 0));
            //g2d.drawRect(10, 10, 100, 46);
            ////g2d.drawString("名称：娃哈哈纯净水",0,10);
            ////g2d.drawString("产地：浙江杭州",0,26);
            ////g2d.drawString("品牌：娃娃哈哈",0,42);
            ////g2d.drawString("单价：9876543210",0,58);
            ////g2d.setFont(font);
            ////释放对象
            //g2d.dispose();
            //// 保存文件
            //ImageIO.write(image, "png", new File("D:/test.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("生成完成");
    }

}
