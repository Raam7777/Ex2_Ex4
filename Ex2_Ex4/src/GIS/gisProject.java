package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class gisProject implements GIS_project {

//-------------------------private---------------------\\
	private ArrayList<GIS_layer> project = new ArrayList<GIS_layer>();
	
	
//------------------------------------------------------\\
	
	
	/**
	 * adding layer to the project.
	 * @param l representing an element.
	 * @return boolean.
	 */
	public boolean add(GIS_layer l) {
		return this.project.add(l);
	}

	/**
	 * adding the collection to the set.
	 * @param collection of layer.
	 * @return boolean.
	 */
	public boolean addAll(Collection<? extends GIS_layer> c) {
		return this.project.addAll(c);
	}

	/**
	 * clearing the Project.
	 */
	public void clear() {
		this.project.clear();
	}

	/**
	 * if the object is in the collection so true, otherwise false.
	 * @param e - object.
	 * @return boolean.
	 */
	public boolean contains(Object o) {
		return this.project.contains(o);
	}

	/**
	 * if the all object is in the collection so true, otherwise false.
	 * @param e - all object.
	 * @return boolean.
	 */
	public boolean containsAll(Collection<?> c) {
		return this.project.containsAll(c);
	}

	/**
	 * if the Peoject is empty so true, otherwise false.
	 *@return boolean.
	 */
	public boolean isEmpty() {
		return this.project.isEmpty();
	}

	/**
	 * Iterator pointing to the layer in the project.
	 * @return iterator.
	 */
	public Iterator<GIS_layer> iterator() {
		return this.project.iterator();
	}

	/**
	 * remove an object from the project.
	 * @return boolean.
	 */
	public boolean remove(Object o) {
		return this.project.remove(o);
	}

	/**
	 * remove a from objects from the project according to the collection given.
	 * @return boolean
	 */
	public boolean removeAll(Collection<?> c) {
		return this.project.removeAll(c);
	}

	/**
	 * retaining only the objects of the given collection.
	 * @return boolean.
	 */
	public boolean retainAll(Collection<?> c) {
		return this.project.retainAll(c);
	}

	/**
	 * The size of the layer in project.
	 * @return how many layer.
	 */
	public int size() {
		return this.project.size();
	}

	/**
	 * turning the collection into array.
	 * @return array of object.
	 */
	public Object[] toArray() {
		return this.project.toArray();
	}

	/**
	 * turning the collection into array according to the array's given objects.
	 *  @return array of object.
	 */
	public <T> T[] toArray(T[] a) {
		return this.project.toArray(a);
	}

	/**
	 *  get metaData to project.
	 *  @return metaData of project.
	 */
	public Meta_data get_Meta_data() {
		return this.project.get(0).get_Meta_data();
	}

}
