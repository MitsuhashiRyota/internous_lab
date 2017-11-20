package jp.co.internous.lab.Application.Util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.stereotype.Component;

/**
 * シリアライズ・デシリアライズUtilクラス
 * @author MitsuhashiRyota
 *
 * @param <E>
 */
@Component
public class SerializableDataUtil<E> {

	/**
	 * シリアライズ化
	 * @param fileName
	 * @param serializableObject
	 */
	public void setSerializableData(String fileName, E serializableObject) {
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {

			System.out.println("シリアライズ開始");
			objectOutputStream.writeObject(serializableObject);
			System.out.println("シリアライズ完了");

		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * デシリアライズ
	 * @param fileName
	 * @param deSerializable
	 * @return
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public E getSerializableDataObject(String fileName) throws ClassNotFoundException {

		E returnObject = null;

		try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
			System.out.println("デシリアライズ開始");
			returnObject = (E)objectInputStream.readObject();
			System.out.println("デシリアライズ完了");
		} catch(IOException e) {
			e.printStackTrace();
		}
		return returnObject;
	}
}
