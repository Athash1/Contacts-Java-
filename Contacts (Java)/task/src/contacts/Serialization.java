package contacts;
import java.io.*;

public class Serialization {
    // serializeObject
    public static void serializeObject(Object object, String fileName) {
        try {
            File file = new File(fileName);

            // 检查文件所在目录是否存在，如果不存在则创建目录
            File parentDir = file.getParentFile();
            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }

            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(object);

            objectOut.close();
            fileOut.close();

            System.out.println("Object serialized successfully.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // deserializeObject
    public static Object deserializeObject(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            // 文件不存在，可以选择跳过反序列化或执行其他处理逻辑
            return null;
        }
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Object object = objectInputStream.readObject();
            System.out.println("Object deserialized successfully.\n");
            return object;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
