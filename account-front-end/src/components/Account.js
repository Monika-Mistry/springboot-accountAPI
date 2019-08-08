import React from 'react';

export default function Account(props) {
    return (
        <tbody>
            {
                props.accounts.map(element => {
                    return (
                        <tr key={element.id}>
                            <td>{element.firstName}</td>
                            <td>{element.lastName}</td>
                            <td>{element.accountNumber}</td>
                            <td>{element.prize}</td>
                        </tr>
                    )
                })
            }
        </tbody>
    )
}