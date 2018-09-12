package com.ssmvue.security;

import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class CaptchaServlet extends HttpServlet{
    private static final long serialVersionUID = 3514434198991101787L;

    public static final String 	CAPTCHA = "captcha";

    private int w = 70;
    private int h = 26;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        createImage(request,response);
    }

    /**
     *
     * @Title: createImage
     * @Description: 创建验证码图片
     * @param @param request
     * @param @param response
     * @param @throws IOException
     * @return void
     * @throws
     *
     */
    private void createImage(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

		/*
		 * 得到参数高，宽，都为数字时，则使用设置高宽，否则使用默认值
		 */
        String width = request.getParameter("width");
        String height = request.getParameter("height");
        if (StringUtils.isNumeric(width) && StringUtils.isNumeric(height)) {
            w = Integer.valueOf(width);
            h = Integer.valueOf(height);
        }

        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        g.setColor(new Color(255, 255, 255));// 设置背景色
        g.fillRect(0, 0, w, h);
        Random random = new Random();
        float yawpRate = 0.09f;// 噪声率
        int area = (int) (yawpRate * w * h);
        for (int i = 0; i < area; i++) {
            int x = random.nextInt(w);
            int y = random.nextInt(h);
            int rgb = getRandomIntColor();
            image.setRGB(x, y, rgb);
        }

        //绘制干扰线
        g.setColor(getRandColor(160, 200));// 设置线条的颜色
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(w - 1);
            int y = random.nextInt(h - 1);
            int xl = random.nextInt(6) + 1;
            int yl = random.nextInt(12) + 1;
            g.drawLine(x, y, x + xl + 40, y + yl + 20);
        }

        //透明背景
        //image = g.getDeviceConfiguration().createCompatibleImage(w, h, Transparency.TRANSLUCENT);
        //g.dispose();

        g = image.createGraphics();

		/*
		 * 生成背景
		 */
        //createBackground(g);

		/*
		 * 生成字符
		 */
        String s = createCharacter(g);
        System.out.println("Session Key:"+CaptchaServlet.CAPTCHA+",验证码："+s);
        request.getSession().setAttribute(CaptchaServlet.CAPTCHA, s);

        shear(g, w, h, new Color(255, 255, 255));

        g.dispose();
        OutputStream out = response.getOutputStream();
        ImageIO.write(image, "png", out);
        out.close();

    }



	/*private Color getRandColor(int fc,int bc) {
		int f = fc;
		int b = bc;
		Random random=new Random();
        if(f>255) {
        	f=255;
        }
        if(b>255) {
        	b=255;
        }
        return new Color(f+random.nextInt(b-f),f+random.nextInt(b-f),f+random.nextInt(b-f));
	}*/


	/*private void createBackground(Graphics g) {
		// 填充背景
		//g.setColor(getRandColor(220,250));
		g.setColor(new Color(255,255,255));
		g.fillRect(0, 0, w, h);
		// 加入干扰线条.不加入干扰线
		for (int i = 0; i < 10; i++) {
			g.setColor(getRandColor(40,150));
			Random random = new Random();
			int x = random.nextInt(w);
			int y = random.nextInt(h);
			int x1 = random.nextInt(w);
			int y1 = random.nextInt(h);
			g.drawLine(x, y, x1, y1);
		}
	}*/

    /**
     *
     * @Title: createCharacter
     * @Description: 创建验证码随机字符串
     * @param @param g
     * @param @return
     * @return String
     * @throws
     *
     */
    private String createCharacter(Graphics2D g) {
        char[] codeSeq = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
                'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        String[] fontTypes = {"\u5b8b\u4f53","\u65b0\u5b8b\u4f53","\u9ed1\u4f53","\u6977\u4f53","\u96b6\u4e66"};
        Random random = new Random();
        StringBuilder s = new StringBuilder();
        //抗锯齿
        //g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        for (int i = 0; i < 4; i++) {
            String r = String.valueOf(codeSeq[random.nextInt(codeSeq.length)]);//random.nextInt(10));
            //g.setColor(new Color(50 + random.nextInt(100), 50 + random.nextInt(100), 50 + random.nextInt(100)));
            g.setColor(new Color(51, 64, 84));
            g.setFont(new Font(fontTypes[random.nextInt(fontTypes.length)],Font.BOLD,20));
            g.drawString(r, 15 * i + 5, 19 + random.nextInt(2));
            s.append(r);
        }
        return s.toString();
    }

    private static int getRandomIntColor() {
        int[] rgb = getRandomRgb();
        int color = 0;
        for (int c : rgb) {
            color = color << 8;
            color = color | c;
        }
        return color;
    }

    private static int[] getRandomRgb() {
        int[] rgb = new int[3];
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            rgb[i] = random.nextInt(255);
        }
        return rgb;
    }

    private static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    private static void shear(Graphics g, int w1, int h1, Color color) {
        shearX(g, w1, h1, color);
        shearY(g, w1, h1, color);
    }

    private static void shearX(Graphics g, int w1, int h1, Color color) {
        Random random = new Random();
        int period = random.nextInt(2);

        boolean borderGap = true;
        int frames = 1;
        int phase = random.nextInt(2);

        for (int i = 0; i < h1; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(0, i, w1, 1, (int) d, 0);
            if (borderGap) {
                g.setColor(color);
                g.drawLine((int) d, i, 0, i);
                g.drawLine((int) d + w1, i, w1, i);
            }
        }

    }

    private static void shearY(Graphics g, int w1, int h1, Color color) {
        Random random = new Random();
        int period = random.nextInt(10) + 5; // 50;

        boolean borderGap = true;
        int frames = 20;
        int phase = 7;
        for (int i = 0; i < w1; i++) {
            double d = (double) (period >> 1)
                    * Math.sin((double) i / (double) period
                    + (6.2831853071795862D * (double) phase)
                    / (double) frames);
            g.copyArea(i, 0, 1, h1, 0, (int) d);
            if (borderGap) {
                g.setColor(color);
                g.drawLine(i, (int) d, i, 0);
                g.drawLine(i, (int) d + h1, i, h1);
            }

        }

    }
}