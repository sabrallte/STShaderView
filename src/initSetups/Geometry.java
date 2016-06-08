package initSetups; 

import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;


public class Geometry {

    public static void drawTorus(float r, float R, int nsides, int rings, double now) {

        glTranslated(0,0,-5);
        glRotatef(20*(float)now,0,1.0f,0);
        glMaterialf(GL_FRONT, GL_SHININESS, 100);

        float ringDelta = 2.0f * (float) Math.PI / rings;
        float sideDelta = 2.0f * (float) Math.PI / nsides;
        float theta = 0.0f, cosTheta = 1.0f, sinTheta = 0.0f;
        for (int i = rings - 1; i >= 0; i--) {
            float theta1 = theta + ringDelta;
            float cosTheta1 = (float) Math.cos(theta1);
            float sinTheta1 = (float) Math.sin(theta1);
            GL11.glBegin(GL11.GL_QUAD_STRIP);
            float phi = 0.0f;
            for (int j = nsides; j >= 0; j--) {
                phi += sideDelta;
                float cosPhi = (float) Math.cos(phi);
                float sinPhi = (float) Math.sin(phi);
                float dist = R + r * cosPhi;
                GL11.glNormal3f(cosTheta1 * cosPhi, -sinTheta1 * cosPhi, sinPhi);
                GL11.glVertex3f(cosTheta1 * dist, -sinTheta1 * dist, r * sinPhi);
                GL11.glNormal3f(cosTheta * cosPhi, -sinTheta * cosPhi, sinPhi);
                GL11.glVertex3f(cosTheta * dist, -sinTheta * dist, r * sinPhi);
            }
            GL11.glEnd();
            theta = theta1;
            cosTheta = cosTheta1;
            sinTheta = sinTheta1;
        }
    }

    public static void drawPlane(int width, int height, double now)
    {
        glTranslated(2, 2, -4);
        glRotatef(-30,1.0f,0,0);

        glMaterialf(GL_FRONT, GL_SHININESS, 100);

        glBegin(GL_QUADS);
        glNormal3f(0.0f,0.0f,1.0f);
        glTexCoord2f(0,1);
        glVertex2f(-width, -height);
        glTexCoord2f(1,1);
        glVertex2f(width, -height);
        glTexCoord2f(1,0);
        glVertex2f(width, height);
        glTexCoord2f(0,0);
        glVertex2f(-width, height);
        glEnd();
    }

}



//halfway fallunterscheidung
