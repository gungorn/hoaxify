import axios from 'axios';

export const userSignUp = async ({ username, displayname, password }) => {
	const body = { username, displayname, password };

	await axios.post('/api/v1/users', body)
		.then(res => { console.log(res); })
		.catch(e => console.log(e));
};
