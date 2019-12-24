package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.splashscreengl

import android.content.Context
import android.opengl.GLES20
import android.opengl.GLSurfaceView
import android.renderscript.Float3
import android.renderscript.Matrix4f
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10


class OpenGLRenderer : GLSurfaceView.Renderer {
    private val ONE_SEC = 1000.0f // 1 second


    private var context: Context? = null
    private var frame: MaskedSquare? = null

    private var lastTimeMillis = 0L

    constructor(context: Context?) {
        this.context = context
    }

    override fun onSurfaceCreated(
        gl10: GL10?,
        eglConfig: EGLConfig?
    ) {
        val shader = ShaderProgram(
            ShaderUtils.readShaderFileFromRawResource(context, R.raw.simple_vertex_shader),
            ShaderUtils.readShaderFileFromRawResource(context, R.raw.simple_fragment_shader)
        )
        val frameTexture: Int = TextureUtils.loadTexture(context, R.drawable.untitled_1)
        frame = MaskedSquare(shader)
        frame!!.setPosition(Float3(0.0f, 0.0f, 0.1f))
        frame!!.setTexture(frameTexture)
        lastTimeMillis = System.currentTimeMillis()
    }

    override fun onSurfaceChanged(gl10: GL10?, w: Int, h: Int) {
        GLES20.glViewport(0, 0, w, h)
        val perspective = Matrix4f()
        perspective.loadPerspective(85.0f, w.toFloat() / h.toFloat(), 1.0f, -150.0f)
        if (frame != null) {
            frame?.setProjection(perspective)
        }
    }

    override fun onDrawFrame(gl10: GL10?) {
        GLES20.glClearColor(1.0f, 0.0f, 0.0f, 0.0f)
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT or GLES20.GL_DEPTH_BUFFER_BIT)
        GLES20.glEnable(GLES20.GL_DEPTH_TEST)
        GLES20.glEnable(GLES20.GL_CULL_FACE)
        GLES20.glEnable(GLES20.GL_BLEND)
        GLES20.glBlendFunc(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA)
        val currentTimeMillis = System.currentTimeMillis()
        updateWithDelta(currentTimeMillis - lastTimeMillis)
        lastTimeMillis = currentTimeMillis
    }

    private fun updateWithDelta(dt: Long) {
        val camera = Matrix4f()
        camera.translate(0.0f, 1.0f, -5.0f)
        frame?.setCamera(camera)
        val secsPerMove = 2.0f * ONE_SEC
        val movement =
            Math.sin(System.currentTimeMillis() * 2 * Math.PI / secsPerMove).toFloat()
        frame?.setPosition(frame?.position?.z?.let { frame?.position?.y?.let { it1 ->
            Float3(movement,
                it1, it)
        } })
        frame?.draw(dt)
    }


}