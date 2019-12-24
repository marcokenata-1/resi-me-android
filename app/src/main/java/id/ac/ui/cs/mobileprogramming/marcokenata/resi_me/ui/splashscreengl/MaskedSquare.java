package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.splashscreengl;

public class MaskedSquare extends Model {

    static final float vertices[] = {
            1.0f, -1.0f, 0f,   1f, 0f,
            1.0f,  1.0f, 0f,   1f, 1f,
            -1.0f,  1.0f, 0f,   0f, 1f,
            -1.0f, -1.0f, 0f,   0f, 0f

    };

    static final short indices[] = {
            0, 1, 2,
            2, 3, 0
    };


    public MaskedSquare(ShaderProgram shader) {
        super("MaskedSquare", shader, vertices, indices);
    }
}
