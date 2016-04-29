package assignment01;

public class KeyPair<T1, T2> {
	public T1 creator;
	public T2 nick;
	
	public KeyPair(T1 creator, T2 nick) {
		this.creator = creator;
		this.nick = nick;
	}

	public T1 getCreator() {
		return creator;
	}

	public void setCreator(T1 creator) {
		this.creator = creator;
	}

	public T2 getNick() {
		return nick;
	}

	public void setNick(T2 nick) {
		this.nick = nick;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyPair<T1, T2> other = (KeyPair<T1, T2>) obj;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (nick == null) {
			if (other.nick != null)
				return false;
		} else if (!nick.equals(other.nick))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		return (creator.toString()+nick.toString()).hashCode();
	}
}
