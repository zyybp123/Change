package cn.xysxtzq.audiolibrary.interf;

/**
 * Created by Administrator on 2018/4/2.
 * 文件类型接口
 */

public interface FileType {
    /**
     * 纯文本 .txt
     */
    String TEXT_PLAIN = "text/plain";

    /**
     * PDF文档 .pdf
     */
    public final static String PDF = "application/pdf";

    /**
     * Microsoft Word文件 .doc .docx .dotx
     */
    public final static String WORD = "application/msword";
    public final static String DOC_X = "application/vnd.openxmlformats-officedocument" +
            ".wordprocessingml.document";
    public final static String DOT_X = "application/vnd.openxmlformats-officedocument" +
            ".wordprocessingml.template";
    /**
     * Microsoft Excel文件 .xls .xlsx .xltx
     */
    public final static String EXCEL = "application/vnd.ms-excel";
    public final static String XLS_X = "application/vnd.openxmlformats-officedocument" +
            ".spreadsheetml.sheet";
    public final static String XLT_X = "application/vnd.openxmlformats-officedocument" +
            ".spreadsheetml.template";
    /**
     * Microsoft PowerPoint文件 .ppt .pptx .potx .ppsx
     */
    public final static String PPT = "application/vnd.ms-powerpoint";
    public final static String PPT_X = "application/vnd.openxmlformats-officedocument" +
            ".presentationml.presentation";
    public final static String POT_X = "vnd.openxmlformats-officedocument" +
            ".presentationml.template";
    public final static String PPS_X = "vnd.openxmlformats-officedocument" +
            ".presentationml.slideshow";

    /**
     * Video .avi .flv .swf .mp4
     */
    public static final String AVI = "video/x-msvideo";
    public static final String FLV = "video/x-flv";
    public static final String SWF = "application/x-shockwave-flash";
    public static final String MP4 = "video/mp4";

    /**
     * Image .jpeg .png .jpg
     */
    public static final String JPG = "image/jpeg";
    public static final String PNG = "image/png";

    /**
     * （使用HTTP的POST方法提交的表单）
     */
    public final static String FORM = "application/x-www-form-urlencoded";
    /**
     * （同上，但主要用于表单提交时伴随文件上传的场合）
     */
    public final static String FORM_DATA = "multipart/form-data";
    /**
     * 所有文件类型集合
     */
    public static final String[] ALL_LIST = new String[]{
            WORD, DOC_X, EXCEL, XLS_X, PPT, PPT_X, PDF, AVI, FLV, SWF, MP4, JPG, PNG
    };
    /**
     * 所有文档文件 Word文档 Excel表格 ppt 和 pdf
     */
    public static final String[] DOCUMENT_LIST_ALL = new String[]{
            WORD, DOC_X, EXCEL, XLS_X, PPT, PPT_X, PDF
    };
    /**
     * 所有视频文件
     */
    public static final String[] VIDEO_LIST = new String[]{
            MP4
    };
    /**
     * 所有图片文件
     */
    public static final String[] IMAGE_LIST = new String[]{
            JPG, PNG
    };
}
