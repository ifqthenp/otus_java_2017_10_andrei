package com.otus.dbService;

import com.otus.dataset.UserDataSet;
import org.hibernate.Session;

/**
 * {@code UserDataSetDAO} class.
 */
public class UserDataSetDAO
{
    private Session session;

    public UserDataSetDAO(Session session)
    {
        this.session = session;
    }

    public void save(UserDataSet dataSet)
    {
        session.save(dataSet);
    }

    public UserDataSet read(final long id)
    {
        return session.load(UserDataSet.class, id);
    }
}
